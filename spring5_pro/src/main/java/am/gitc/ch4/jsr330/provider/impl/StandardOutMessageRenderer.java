package am.gitc.ch4.jsr330.provider.impl;

import am.gitc.ch4.jsr330.provider.MessageProvider;
import am.gitc.ch4.jsr330.provider.MessageRenderer;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.inject.Singleton;
//
//@Named( "renderer")
//@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {

    private final MessageProvider provider;

//    @Inject
//    @Named("provider")
    public StandardOutMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        if (provider == null) throw new RuntimeException(
                "You must set the property messageProvider of class:"
                        + StandardOutMessageRenderer.class.getName());
        System.out.println(provider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return provider;
    }

}
