package am.gitc.aspect;

import am.gitc.advices.ProfilingInterceptor;
import am.gitc.model.WorkerBean;
import org.springframework.aop.framework.ProxyFactory;

public class ProfilingDemo {

    public static void main(String[] args) {
       WorkerBean bean = getWorkerBean();
       bean.doSomeWork(1000000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean workerBean = new WorkerBean();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(workerBean);
        pf.addAdvice(new ProfilingInterceptor());
        return (WorkerBean) pf.getProxy();
    }
}
