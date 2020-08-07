package am.gitc.ch4.jsr330.provider;

public interface MessageRenderer {
    void render();
    MessageProvider getMessageProvider();
}
