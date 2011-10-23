package com.emal.kladr.web;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/23/11 9:49 PM
 */
public class SpringVaadinServlet extends AbstractApplicationServlet {

    /**
     * Class serial version unique identifier.
     */
    private static final long serialVersionUID = 1L;

    private Class clazz;

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(
                config.getServletContext());

        Application application = (Application) wac.getBean("application", Application.class);

        clazz = application.getClass();
    }

    /**
     * Gets the application from the Spring context.
     *
     * @return The Spring bean named 'application'
     */
    @Override
    protected Application getNewApplication(HttpServletRequest request)
            throws ServletException {

        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(
                request.getSession().getServletContext());

        return (Application) wac.getBean("application", Application.class);
    }

    /**
     * @see com.vaadin.terminal.gwt.server.AbstractApplicationServlet#getApplicationClass()
     */
    @Override
    protected Class getApplicationClass()
            throws ClassNotFoundException {

        return clazz;
    }
}
