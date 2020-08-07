package am.gitc;

import am.gitc.config.AppConfig;
import am.gitc.service.impl.TaskToExecute;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

public class TaskExecutorDemo {

    public static void main(String[] args) throws IOException {
        GenericApplicationContext  ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskToExecute taskToExecute = ctx.getBean(TaskToExecute.class);
        taskToExecute.executeTask();
        System.in.read();
        ctx.close();
    }
}
