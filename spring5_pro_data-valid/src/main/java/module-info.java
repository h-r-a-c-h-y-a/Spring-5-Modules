module spring5.pro.data.valid {
    requires java.desktop;
    requires java.annotation;
    requires spring.beans;
    requires spring.context;
    requires spring.core;
    requires slf4j.api;
    requires org.joda.time;
    exports am.gitc to spring.beans, spring.context;
    opens am.gitc to spring.core;
}