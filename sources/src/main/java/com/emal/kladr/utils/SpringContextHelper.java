package com.emal.kladr.utils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * User: admin
 * Date: 22.10.11 15:42
 */
public class SpringContextHelper {

    private ApplicationContext context;

    public SpringContextHelper(Application application) {
        ServletContext servletContext = ((WebApplicationContext) application.getContext()).getHttpSession().getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    public Object getBean(final String beanRef) {
        return context.getBean(beanRef);
    }

    public Object getBean(final Class aClass) {
        return context.getBean(aClass);
    }
}