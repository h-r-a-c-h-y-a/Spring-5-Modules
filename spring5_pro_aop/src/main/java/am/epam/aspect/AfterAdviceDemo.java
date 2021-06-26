package am.gitc.aspect;

import am.gitc.advices.WeakKeyCheckAdvice;
import am.gitc.model.KeyGenerator;
import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakKeyCheckAdvice());
        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator generator = getKeyGenerator();
        for (int i = 0; i < 10; i++) {
            try {
                long key = generator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException ex) {
                System.out.println("Weak Кеу Generated!");
            }
        }
    }
}
