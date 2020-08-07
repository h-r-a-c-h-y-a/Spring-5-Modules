package am.gitc.ch4.provider.impl;

import am.gitc.ch4.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    private String msg;

    public HelloWorldMessageProvider(@Value ("Love on the weekend") String msg) {
        this.msg = msg;
    }

    @Override
    public String getDefMessage() {
        return "Hello World!!!";
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
