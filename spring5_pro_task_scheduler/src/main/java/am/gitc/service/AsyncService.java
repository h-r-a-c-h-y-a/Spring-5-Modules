package am.gitc.service;

import java.util.concurrent.Future;

public interface AsyncService {

    void asyncTask();
    Future<String> asyncWithReturn(String name);

}