module spring5.pro {
    exports am.gitc.ch4.jsr330.provider.impl to spring.beans;
//    exports am.gitc.ch4.profiles.highschool to spring.am.gitc.beans;
//    exports am.gitc.ch4.profiles.kindergarten to spring.am.gitc.beans;
    opens am.gitc.ch4.config to spring.core, spring.beans, spring.context;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires java.xml;
    requires java.sql;
    requires javax.inject;
    requires groovy.all.minimal;
}