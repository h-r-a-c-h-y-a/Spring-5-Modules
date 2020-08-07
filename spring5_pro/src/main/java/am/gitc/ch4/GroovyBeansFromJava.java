package am.gitc.ch4;


import am.gitc.ch4.groovy.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:am/gitc/beans.groovy");
        Singer singer = ctx.getBean("singer", Singer.class);
        System.out.println(singer);
    }
}
