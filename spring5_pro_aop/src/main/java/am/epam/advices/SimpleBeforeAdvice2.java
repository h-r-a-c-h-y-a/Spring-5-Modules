package am.gitc.advices;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice2 implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before method: " + method);
    }
}
