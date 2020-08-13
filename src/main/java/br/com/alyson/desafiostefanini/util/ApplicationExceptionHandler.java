package br.com.alyson.desafiostefanini.util;

import br.com.alyson.desafiostefanini.service.exception.BusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.io.IOException;
import java.util.Iterator;

public class ApplicationExceptionHandler extends ExceptionHandlerWrapper {

    private static Log log = LogFactory.getLog(ApplicationExceptionHandler.class);

    private ExceptionHandler wrapped;

    public ApplicationExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

        while (events.hasNext()) {
            ExceptionQueuedEvent event = events.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            Throwable exception = context.getException();
            BusinessException businessException = getBusinessExceptionException(exception);

            boolean handled = false;

            try {
                if (exception instanceof ViewExpiredException) {
                    handled = true;
                    redirect("/");
                } else if (businessException != null) {
                    handled = true;
                    ApplicationUtil.addErrorMessage(businessException.getMessage());
                } else {
                    handled = true;
                    log.error("Erro de sistema: " + exception.getMessage(), exception);
                    redirect("/Erro.xhtml");
                }
            } finally {
                if (handled) {
                    events.remove();
                }
            }
        }

        getWrapped().handle();
    }

    private BusinessException getBusinessExceptionException(Throwable exception) {
        if (exception instanceof BusinessException) {
            return (BusinessException) exception;
        } else if (exception.getCause() != null) {
            return getBusinessExceptionException(exception.getCause());
        }

        return null;
    }

    private void redirect(String page) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String contextPath = externalContext.getRequestContextPath();

            externalContext.redirect(contextPath + page);
            facesContext.responseComplete();
        } catch (IOException e) {
            throw new FacesException(e);
        }
    }
}
