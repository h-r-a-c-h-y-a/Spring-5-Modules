package com.gitc.mvc_demo;

import com.gitc.mvc_demo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
