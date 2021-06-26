package am.gitc.advices;

import am.gitc.model.Guitarist;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public static void main(String[] args) {
        Guitarist target = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(new SimpleAfterReturningAdvice());
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing("A song about love");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println ("After '" + method. getName ()
                + "' put down guitar.");
    }
}
