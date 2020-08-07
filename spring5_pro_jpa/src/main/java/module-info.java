module spring5.pro.jpa {
    requires java.sql;
    requires java.xml;
    requires java.persistence;
    requires java.annotation;
    requires java.naming;
    requires spring.context;
    requires spring.context.support;
    requires spring.beans;
    requires spring.core;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires org.aspectj.runtime;
    requires org.hibernate.orm.core;
    requires org.slf4j;
    requires commons.dbcp;
    requires lombok;
    requires net.bytebuddy;
    requires java.xml.bind;
    requires google.collections;
    opens am.gitc.config to spring.core;
    opens am.gitc.entities to org.hibernate.orm.core, spring.core;
    opens am.gitc.service.impl to  spring.core;
    exports am.gitc.service.impl to  spring.beans;
    exports am.gitc.repository to  spring.beans;
    exports am.gitc.entities to  spring.beans, spring.data.commons;
    exports am.gitc.service to  spring.aop;
    exports am.gitc.config to spring.beans, spring.context;
}