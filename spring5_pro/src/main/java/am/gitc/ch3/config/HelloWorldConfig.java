package am.gitc.ch3.config;

import am.gitc.ch3.provider.impl.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "am.gitc")
public class HelloWorldConfig {

    @Autowired
    private  Singer singer;
//    @Bean
//    public MessageProvider provider() {
//        return new HelloWorldMessageProvider();
//    }
//
//    @Bean
//    public MessageRenderer renderer(MessageProvider provider){
//        return new StandardOutMessageRenderer(provider);
//    }
}
