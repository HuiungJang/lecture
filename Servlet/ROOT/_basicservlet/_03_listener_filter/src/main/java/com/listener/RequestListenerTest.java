package com.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
// web.xml에 등록한 것과 똑같다.
// annotation
@WebListener
public class RequestListenerTest implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener,ServletRequestListener {
    private int count;

    public RequestListenerTest() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("요청이 들어왔어");
        System.out.println(sre.getServletContext().getContextPath());
        System.out.println(((HttpServletRequest)sre.getServletRequest()).getRequestURL());
        String url = new String((((HttpServletRequest) sre.getServletRequest()).getRequestURL()));
        if(url.contains("login.do")){
            count++;
        }
        sre.getServletRequest().getParameterMap();
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("요청이 사라졌어");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
