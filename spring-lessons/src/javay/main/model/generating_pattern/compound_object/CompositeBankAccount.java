package javay.main.model.generating_pattern.compound_object;

import java.util.ArrayList;
import java.util.List;

public class CompositeBankAccount implements Account{
    private List<Account> childAccounts = new ArrayList<>();

    @Override
    public void accountType() {
    childAccounts.forEach(Account::accountType);
    }

    public void add(Account account) {
        childAccounts.add(account);
    }

    public void remove(Account account) {
        childAccounts.remove(account);
    }
}
