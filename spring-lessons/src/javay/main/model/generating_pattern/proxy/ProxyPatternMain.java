package javay.main.model.generating_pattern.proxy;

public class ProxyPatternMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Account account = new ProxySavingAccount(SavingAccount.class);
        account.accountType();
        new ProxySavingAccount(CurrentAccount.class).accountType();
    }
}
