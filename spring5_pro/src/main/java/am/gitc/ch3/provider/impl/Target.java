package am.gitc.ch3.provider.impl;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target(){}
    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }
    public Target(Foo foo, Bar bar) {
        this.fooOne = foo;
        this.bar = bar;
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        System.out.println("Property fooTwo set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("static/ch3/app-context-03.xml");
        ctx.refresh();
        Target t = null;
        System.out.println("Using byName:\n");
        t = (Target) ctx.getBean("targetName");
        System.out.println("\nUsing byType:\n");
        t = (Target) ctx.getBean("targetType");
        System.out.println("\nUsing constructor:\n");
        t = (Target) ctx.getBean("targetConstructor");
        ctx.close();
    }
}
