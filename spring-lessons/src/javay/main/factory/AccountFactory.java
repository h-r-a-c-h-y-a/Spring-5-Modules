package javay.main.factory;

import javay.main.model.generating_pattern.abstract_factory.Bank;
import javay.main.model.generating_pattern.abstract_factory.Account;
import javay.main.model.generating_pattern.abstract_factory.CurrentAccount;
import javay.main.model.generating_pattern.abstract_factory.SavingAccount;

public class AccountFactory extends AbstractFactory{
    final String CURRENT_ACCOUNT = "CURRENT";
    final String SAVING_ACCOUNT = "SAVING";

    @Override
    Bank getBank(String bankName) {
        return null;
    }

    public Account getAccount(String accountType) {
        switch (accountType) {
            case CURRENT_ACCOUNT: return new CurrentAccount();
            case SAVING_ACCOUNT: return new SavingAccount();
            default: return null;
        }
    }
}
