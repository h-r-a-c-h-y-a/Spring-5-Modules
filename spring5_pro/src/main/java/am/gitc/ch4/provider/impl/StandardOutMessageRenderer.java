package am.gitc.ch4.provider.impl;

import am.gitc.ch4.provider.MessageProvider;
import am.gitc.ch4.provider.MessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service( "messageRenderer")
@Scope(value = "prototype")
@DependsOn(value = "provider")
public class StandardOutMessageRenderer implements MessageRenderer {

    private final MessageProvider provider;

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

}
