package am.gitc;

import am.gitc.ch4.jsr330.provider.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Demo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:static/ch4/app-context.xml");
        ctx.refresh();
        MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
        renderer.render();
        ctx.close();
    }
}
