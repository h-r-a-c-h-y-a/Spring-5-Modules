package am.gitc.advices;

import am.gitc.model.KeyGenerator;
import org.springframework.aop.AfterReturningAdvice;
import static am.gitc.model.KeyGenerator.*;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] objects, Object target) throws Throwable {
        if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = (Long) returnValue;
            if (key == WEAK_KEY)
                throw new SecurityException("Key Generator "
                        + "generated а weak key. Try again");
        }
    }
}
