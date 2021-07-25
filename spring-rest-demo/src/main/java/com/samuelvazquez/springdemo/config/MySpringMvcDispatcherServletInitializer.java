package com.samuelvazquez.springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// AbstractAnnotationConfigDispatcherServletInitializer is a base class to initialize Spring application in
// Servlet container environment. It's an extension of WebApplicationInitializer.
// WebApplicationInitializer to register a DispatcherServlet and use Java-based Spring configuration.
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // for DispatcherServlet application context (Spring MVC infrastructure) configuration
    // Specify @Configuration and/or @Component classes for the Servlet application context.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class [] {DemoAppConfig.class};
    }

    // mao to root path
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
