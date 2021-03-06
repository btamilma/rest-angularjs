package com.btamilmani;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer {
//public class MyWebApplicationInitializer implements WebApplicationInitializer {

    //@Override
    public void onStartup(ServletContext container) {
    	XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/applicationContext.xml");
        
        ServletRegistration.Dynamic registration = container.addServlet("springbatch", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/springbatch/*");
    }

}
