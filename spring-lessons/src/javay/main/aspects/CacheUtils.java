package javay.main.aspects;

import org.aspectj.lang.JoinPoint;

public class CacheUtils {

    public static String toKey(JoinPoint point) {
       return point.toString();
    }
}
