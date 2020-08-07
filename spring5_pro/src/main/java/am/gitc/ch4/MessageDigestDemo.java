package am.gitc.ch4;

import am.gitc.ch4.factory.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("static/ch4/app-context.xml");
        ctx.refresh();
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!!!");
        ctx.close();
    }
}
