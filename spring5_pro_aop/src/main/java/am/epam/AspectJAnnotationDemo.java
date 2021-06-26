package am.gitc;

import am.gitc.model.NewDocurnentarist;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("static/app-context.xml");
        ctx.refresh();
        NewDocurnentarist docurnentarist = ctx.getBean("documentarist", NewDocurnentarist.class);
        docurnentarist.execute();
    }
}
