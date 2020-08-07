package am.gitc.model;

import java.util.Random;

public class KeyGenerator {
    public static final long WEAK_KEY = 0xFFFFFFF00000L;
    public static final long STRONG_КЕУ = 0xACDF03F590AE56L;

    private Random random = new Random();

    public long getKey() {
        int x =  random.nextInt(3);
        if (x == 1) return WEAK_KEY;
        return STRONG_КЕУ;
    }
}
