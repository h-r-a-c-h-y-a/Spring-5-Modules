package javay.main.aspects;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* *.transferAmount(..))")
    public void logBeforeTransfer() {
        System.out.println("####Вызов метода LoggingAspect.logBeforeTransfer() " +
                "перед переводом суммы ####");
    }

    @After("execution(* *.transferAmount(..))")
    public void logAfterTransfer() {
        System.out.println("####Вызов метода LoggingAspect.logBeforeTransfer()" +
                " после перевода суммы####");
    }

}
