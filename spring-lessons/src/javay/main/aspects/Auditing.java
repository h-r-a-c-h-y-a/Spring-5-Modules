package javay.main.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;


public class Auditing {

    private final Map<String, Object> cacheStore = new HashMap<>();

    public void validate() {
        System.out.println("банк проверяет ваши учетные данные " +
                "до перевода средств");
    }

      public void transferInstantiate() {
        System.out.println("банк создает экземпляр сервиса перевода средств");
    }

     public void success() {
        System.out.println("банк успешно выполнил перевод средств");
    }

    public void rollback() {
        System.out.println("банк откатил операцию перевода средств");
    }

    public Object cache(ProceedingJoinPoint point) throws Throwable {
        Object value = cacheStore.get(javay.main.aspects.CacheUtils.toKey(point));
        if (value == null) {
            value = point.proceed();
            cacheStore.put(javay.main.aspects.CacheUtils.toKey(point), value);
        }
        return value;
    }
}
