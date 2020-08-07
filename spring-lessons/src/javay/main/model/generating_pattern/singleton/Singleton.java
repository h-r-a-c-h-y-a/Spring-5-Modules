package javay.main.model.generating_pattern.singleton;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        if (instance != null)
            throw new AssertionError("Unauthorized access to create an object");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) return new Singleton();
            }
        }
        return instance;
    }
}
