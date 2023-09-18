//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.lib_management.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class mvc_config extends AbstractAnnotationConfigDispatcherServletInitializer {
    public mvc_config() {
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{main_config.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
