package am.gitc;

import am.gitc.ch4.config.AppConfig;
import am.gitc.ch4.profiles.Food;
import am.gitc.ch4.profiles.FoodProviderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:static/ch4/*-config.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        ctx.refresh();
        FoodProviderService service = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = service.provideLunchSet();
        lunchSet.forEach(food -> System.out.println("Food: " + food.getName()));
//        ctx.close();
    }
}
