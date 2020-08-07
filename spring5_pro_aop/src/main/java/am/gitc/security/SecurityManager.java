package am.gitc.security;

import am.gitc.model.UserInfo;

public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String username, String password) {
        threadLocal.set(new UserInfo(username, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }
}