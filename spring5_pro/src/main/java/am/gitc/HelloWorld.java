package am.gitc;

import am.gitc.ch3.provider.impl.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("static/ch3/app-context-xml.xml");
        ctx.refresh();
        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);
        Map<String, Object> beansOfType = ctx.getBeansOfType(Object.class);
        beansOfType.forEach((key, value) -> System.out.println(key + ": " + value));
        beans.forEach((key, value) -> System.out.println(key + ": " + value));
//        MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
//        renderer.render();
    }
}
