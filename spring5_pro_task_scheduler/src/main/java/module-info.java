module spring5.pro.task.scheduler {
    requires spring.context;
    requires spring.tx;
    requires spring.data.jpa;
    requires spring.orm;
    requires spring.beans;
    requires spring.core;
    requires java.sql;
    requires slf4j.api;
    requires commons.dbcp;
    requires org.joda.time;
    requires java.annotation;
    requires org.hibernate.orm.core;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;
    requires java.persistence;
    opens am.gitc.service.impl to spring.core;
    opens am.gitc.config to spring.core;
    opens am.gitc.entities to org.hibernate.orm.core, spring.core;
    exports am.gitc.entities to spring.beans;
    exports am.gitc.service.impl to spring.beans, spring.context;
    exports am.gitc.config to spring.beans, spring.context;
    exports am.gitc.service to spring.beans, spring.aop;
}