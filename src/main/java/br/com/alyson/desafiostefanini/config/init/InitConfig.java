package br.com.alyson.desafiostefanini.config.init;

import br.com.alyson.desafiostefanini.config.AppConfig;
import br.com.alyson.desafiostefanini.config.DBConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class InitConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(new Class<?>[]{DBConfig.class, AppConfig.class});
        ctx.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
