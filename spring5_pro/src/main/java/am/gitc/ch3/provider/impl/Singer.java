package am.gitc.ch3.provider.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Singer {

    private String lyric = "Down there below us, under the clouds";

    public void sing() {
        System.out.println(lyric);
    }
}
