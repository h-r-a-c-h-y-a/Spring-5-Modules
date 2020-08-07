package am.gitc.ch4.jsr330.provider.impl;

import am.gitc.ch4.jsr330.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//import javax.inject.Inject;
//import javax.inject.Named;
//
//@Named("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    private String msg;

//    @Inject
//    @Named("message")
//    public HelloWorldMessageProvider(String msg) {
//        this.msg = msg;
//    }

    @Override
    public String getMessage() {
        return "Hello World!!!";
    }

    @Override
    public void setMessage(String msg) {
        this.msg = msg;
    }
}
