package am.gitc.ch4.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String msg) {
        ctx.publishEvent(new MessageEvent(this, msg));
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext(
                        "classpath:static/ch4/app-context.xml");
        Publisher publisher = ctx.getBean("publisher", Publisher.class);
        publisher.publish("I send an SOS to the world ... ");
        publisher.publish(" ... I hope that someone gets my ... ");
        publisher.publish(" ... Message in а bottle");
    }
}
