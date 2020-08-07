package am.gitc.ch4.config;

import am.gitc.ch4.provider.MessageProvider;
import am.gitc.ch4.provider.MessageRenderer;
import am.gitc.ch4.provider.impl.HelloWorldMessageProvider;
import am.gitc.ch4.provider.impl.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "am.gitc.ch4")
public class AppConfig {

//
//    public MessageProvider provider() {
//        return new HelloWorldMessageProvider();
//    }
//
//    public MessageRenderer renderer(MessageProvider provider) {
//        return new StandardOutMessageRenderer(provider);
//    }
}
