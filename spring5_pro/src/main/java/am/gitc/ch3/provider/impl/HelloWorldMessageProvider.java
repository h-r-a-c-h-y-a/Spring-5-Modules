package am.gitc.ch3.provider.impl;

import am.gitc.ch3.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    private Singer singer;

    @Autowired
    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public String getMessage() {
        return "Hello World!!!";
    }
}
