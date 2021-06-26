package am.gitc;

import am.gitc.advices.NoOpBeforeAdvice;
import am.gitc.pointcuts.TestPointcut;
import am.gitc.proxyies.DefaultSimpleBean;
import am.gitc.proxyies.SimpleBean;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {
    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(
                new TestPointcut(),
                new NoOpBeforeAdvice());
        runCglibTests(advisor, target);
        runCglibFrozenTests(advisor, target);
        runJdkTests(advisor, target);
    }

    private static void runCglibTests(Advisor advisor,
                                      SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.setProxyTargetClass(true);
        pf.addAdvisor(advisor);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
    }

    private static void runCglibFrozenTests(Advisor advisor,
                                            SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.setProxyTargetClass(true);
        pf.addAdvisor(advisor);
        pf.setFrozen(true);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        System.out.println("Running CGLIB (Frozen) Tests");
        test(proxy);
    }

    private static void runJdkTests(Advisor advisor,
                                    SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(SimpleBean.class);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
    }

    private static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int х = 0; х < 500000; х++) {
            bean.advised();
            after = System.currentTimeMillis();
            System.out.println("Took" + (after - before) + "ms");
            System.out.println("Testing Unadvised Method");
            before = System.currentTimeMillis();
        }
        after = System.currentTimeMillis();
        System.out.println("Took" + (after - before) + "ms");
        Advised advised = (Advised) bean;
        System.out.println(
                "Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int х = 0; х < 500000; х++) {
            advised.getTargetClass();
            after = System.currentTimeMillis();
            System.out.println("Took " + (after - before) + " ms");
            System.out.println(">>>\n");
        }
    }
}
