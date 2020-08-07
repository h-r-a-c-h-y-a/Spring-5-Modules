package am.gitc;

import am.gitc.config.JpaConfig;
import am.gitc.service.SingerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
public class Main {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        SingerService service = ctx.getBean(SingerService.class);
        service.findAll().forEach(System.out::println);
    }

}
