/*
package com.mysuperscore.listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
        sce.getServletContext().setAttribute("applicationContext", ac);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
*/
