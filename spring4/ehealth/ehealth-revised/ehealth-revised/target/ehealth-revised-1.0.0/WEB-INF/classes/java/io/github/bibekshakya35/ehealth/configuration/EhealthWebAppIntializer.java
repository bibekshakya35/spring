/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * bootstrapping a spring mvc we application
 *
 * @author Bibek Shakya
 */
public class EhealthWebAppIntializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(EhealthCofiguration.class);
//        ServletRegistration.Dynamic dispatcher =servletContext.addServlet("SpringDispatcher", new DispatcherServlet(applicationContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/ehealth");
    }
}
