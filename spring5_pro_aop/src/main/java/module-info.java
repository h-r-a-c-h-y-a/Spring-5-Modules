module spring5.pro.aop {
    requires java.sql;
    requires spring.aop;
    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires org.aspectj.weaver;
    exports am.gitc.advices to spring.beans, spring.aop;
    exports am.gitc.config to spring.beans, spring.context;
    exports am.gitc.model to spring.core, spring.aop, spring.beans;
    opens am.gitc.config to spring.core, spring.aop;
    opens am.gitc.model to spring.core, spring.aop;
}