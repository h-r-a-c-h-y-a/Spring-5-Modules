package am.gitc;

import am.gitc.config.AppConfig;
import am.gitc.config.DataServiceConfig;
import am.gitc.service.CarService;
import am.gitc.service.impl.CarServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

public class ScheduleTaskDemo {

    private static Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    public static void main(String[] args) throws InterruptedException, IOException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        CarService service = ctx.getBean(CarService.class);
//        while (!service.isDone()) {
//            logger.info("Waiting for scheduled job to end ...");
//            Thread.sleep(250);
//        }
        System.in.read();
        ctx.close();
    }
}
