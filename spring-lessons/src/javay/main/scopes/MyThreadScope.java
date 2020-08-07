package javay.main.scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

public class MyThreadScope implements Scope {

    private final ThreadLocal<Object> myThreadScope = ThreadLocal.withInitial(() -> {
        System.out.println("initialize ThreadLocal");
        return new HashMap<String, Object>();
    });
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        @SuppressWarnings("unchecked")
        Map<String, Object> scope = (Map<String, Object>) myThreadScope.get();
        System.out.println("getting object from scope.");
        Object obj = scope.get(name);
        if (obj == null) {
            obj = objectFactory.getObject();
            scope.put(name, obj);
        }
        return obj;
    }

    @Override
    public Object remove(String name) {
        System.out.println("removing object from scope.");
        @SuppressWarnings("unchecked")
        Map<String, Object> scope = (Map<String, Object>) myThreadScope.get();
        scope.remove(name);
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
