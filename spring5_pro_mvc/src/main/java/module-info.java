module spring5.pro.mvc {
    requires java.validation;
    requires javax.servlet.api;
    requires java.sql;
    requires java.annotation;
    requires java.xml.bind;
    requires java.naming;
    requires java.persistence;
    requires commons.dbcp;
    requires org.apache.commons.io;
    requires com.fasterxml.jackson.databind;
    requires guava.collections.r03;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.context;
    requires spring.tx;
    requires spring.webmvc;
    requires spring.web;
    requires spring.security.web;
    requires spring.security.config;
    requires spring.security.core;
    requires spring.beans;
    requires spring.orm;
    requires spring.jdbc;
    requires spring.core;
    requires org.slf4j;
    requires net.bytebuddy;
    requires hibernate.entitymanager;
    requires hibernate.validator;
    requires org.hibernate.orm.core;
    opens am.gitc.config to spring.core;
    opens am.gitc.entities to org.hibernate.orm.core, spring.core;
    exports am.gitc.entities to spring.beans;
    exports am.gitc.config to spring.beans, spring.context;
    exports am.gitc.service.impl to spring.beans;
    exports am.gitc.service to spring.aop;
}