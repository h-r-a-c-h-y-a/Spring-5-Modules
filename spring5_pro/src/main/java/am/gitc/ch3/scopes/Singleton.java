package am.gitc.ch3.scopes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

    private static final Singleton instance;
    static {
        instance = new Singleton();
    }
    private Singleton() {
        if (instance != null)
            throw new AssertionError("wrong operation");
    }
    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton singleton = Singleton.getInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton newSingleton = constructor.newInstance();
        System.out.println(singleton.equals(newSingleton));
    }
}
