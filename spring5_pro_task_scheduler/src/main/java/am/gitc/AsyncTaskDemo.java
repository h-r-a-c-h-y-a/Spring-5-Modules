package am.gitc;

import am.gitc.config.AppConfig;
import am.gitc.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncTaskDemo {
    private static Logger logger = LoggerFactory.getLogger(AsyncTaskDemo.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        GenericApplicationContext ctx = new  AnnotationConfigApplicationContext(AppConfig.class);
        AsyncService service = ctx.getBean("asyncService", AsyncService.class);
        for (int i = 0; i < 5; i++) {
            service.asyncTask();
        }
        Future<String> result1 = service.asyncWithReturn("John Mayer");
        Future<String> result2 = service.asyncWithReturn("Eric Clapton");
        Future<String> result3 = service.asyncWithReturn("John Butler");
        Thread.sleep(6000);
        logger.info("Result1: " + result1.get());
        logger.info("Result2: " + result2.get());
        logger.info("Result3: " + result3.get());
        System.in.read();
        ctx.close();
    }
}
