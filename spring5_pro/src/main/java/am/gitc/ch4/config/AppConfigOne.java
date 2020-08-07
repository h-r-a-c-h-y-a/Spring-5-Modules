package am.gitc.ch4.config;

import am.gitc.ch4.provider.MessageProvider;
import am.gitc.ch4.provider.MessageRenderer;
import am.gitc.ch4.provider.impl.HelloWorldMessageProvider;
import am.gitc.ch4.provider.impl.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:message.properties")
@Import(AppConfig.class)
public class AppConfigOne {

    @Autowired
    Environment env;

//    @Bean(name = "messageRenderer")
//    @Scope(value = "prototype")
//    @DependsOn(value = "provider")
//    public MessageRenderer renderer(MessageProvider provider) {
//        return new StandardOutMessageRenderer(provider);
//    }
}
