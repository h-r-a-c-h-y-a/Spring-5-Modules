package am.gitc.ch3.provider.impl;

import am.gitc.ch3.provider.MessageProvider;
import am.gitc.ch3.provider.MessageRenderer;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    private final MessageProvider provider;
    private final Singer singer;

    public StandardOutMessageRenderer(MessageProvider provider, Singer singer) {
        this.provider = provider;
        this.singer = singer;
    }

    @Override
    public void render() {
        if (provider == null) throw new RuntimeException(
                "You must set the property messageProvider of class:"
                        + StandardOutMessageRenderer.class.getName());
        System.out.println(provider.getMessage());
    }

}
