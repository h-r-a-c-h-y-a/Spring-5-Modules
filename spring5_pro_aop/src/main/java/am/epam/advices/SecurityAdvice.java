package am.gitc.advices;

import am.gitc.model.UserInfo;
import am.gitc.security.SecurityManager;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager manager;

    public SecurityAdvice() {
        this.manager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo userInfo = manager.getLoggedOnUser();
        if (userInfo == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login "
                    + "before attempting to invoke the method: "
                    + method.getName());
        } else if ("John".equals(userInfo.getUserName()) && "pwd".equals(userInfo.getPassword())) {
            System.out.println("Logged in user is John - ОКАУ!");
        } else {
            System.out.println("Logged in user is"
                    + userInfo.getUserName () + " NOT GOOD :(") ;
            throw new SecurityException("User "
                    + userInfo.getUserName() + " is not allowed "
                    + "access to method " + method.getName());
        }
    }
}
