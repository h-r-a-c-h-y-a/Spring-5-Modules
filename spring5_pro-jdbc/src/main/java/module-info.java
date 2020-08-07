module spring5.pro.jdbc {
    requires java.sql;
    requires spring.core;
    requires spring.beans;
    requires spring.jdbc;
    requires spring.context;
    requires spring.context.support;
    requires lombok;
    requires org.slf4j;
    requires org.postgresql.jdbc;
    exports newer.config to spring.beans, spring.context;
    opens newer.config to spring.core;
}