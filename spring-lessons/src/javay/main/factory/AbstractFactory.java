package javay.main.factory;

import javay.main.model.generating_pattern.abstract_factory.Bank;
import javay.main.model.generating_pattern.abstract_factory.Account;

public abstract class AbstractFactory {

    abstract Bank getBank(String bankName);
    abstract Account getAccount(String accountType);
}
