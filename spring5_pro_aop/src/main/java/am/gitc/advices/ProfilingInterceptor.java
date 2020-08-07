package am.gitc.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();
        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());
        return retVal;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();
        System.out.println("Executed method: "+ m.getName() );
        System.out.println("On object of type: "
                + target.getClass().getName());
        System.out.print("With arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(" > " + args[i]);
        }
        System.out.print("\n");
        System.out.println("Took: "+ ms +" ms");
    }
}
