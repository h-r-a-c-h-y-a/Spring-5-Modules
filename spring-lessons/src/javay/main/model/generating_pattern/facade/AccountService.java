package javay.main.model.generating_pattern.facade;

public class AccountService {
    public static Account getAccount(String accountId) {
        return new SavingAccount();
    }
}
