package am.gitc.aspect;

import am.gitc.advices.SimpleAdvice;
import am.gitc.model.GoodGuitarist;
import am.gitc.model.GreatGuitarist;
import am.gitc.model.Singer;
import am.gitc.pointcuts.SimpleStaticPointcut;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String[] args) {
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();

        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);
        Singer proxyOne = (Singer) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(ericClapton);
        Singer proxyTwo = (Singer) pf.getProxy();
        proxyOne.sing("A song about love");
        proxyTwo.sing("A song about love");
    }
}
