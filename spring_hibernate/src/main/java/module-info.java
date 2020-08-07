module spring.hibernate {
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
    requires org.hibernate.orm.core;
    requires org.slf4j;
    requires commons.dbcp;
    requires lombok;
    requires net.bytebuddy;
    requires java.xml.bind;
    opens am.gitc.config to spring.core;
    opens am.gitc.entities to org.hibernate.orm.core;
    opens am.gitc.dao.impl to  spring.core;
    exports am.gitc.dao.impl to  spring.beans;
    exports am.gitc.dao to  spring.aop;
    exports am.gitc.config to spring.beans, spring.context;
}