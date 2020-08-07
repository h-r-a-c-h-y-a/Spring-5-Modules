package javay.main.model.generating_pattern.proxy;

public class ProxySavingAccount implements Account{
   private Account savingAccount;

    public ProxySavingAccount(Class<? extends Account> clazz) throws IllegalAccessException, InstantiationException {
        this.savingAccount = clazz.newInstance();
    }

    @Override
    public void accountType() {
        savingAccount.accountType();
    }
}
