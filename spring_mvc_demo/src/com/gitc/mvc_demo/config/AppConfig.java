package com.gitc.mvc_demo.config;

import com.gitc.mvc_demo.service.AccountService;
import com.gitc.mvc_demo.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.gitc.mvc_demo")
public class AppConfig {

}
