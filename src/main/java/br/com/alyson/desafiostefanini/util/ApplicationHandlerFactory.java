package br.com.alyson.desafiostefanini.util;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ApplicationHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;

    public ApplicationHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new ApplicationExceptionHandler(parent.getExceptionHandler());
    }
}
