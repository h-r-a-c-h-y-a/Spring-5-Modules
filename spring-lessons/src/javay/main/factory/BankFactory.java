package javay.main.factory;

import javay.main.model.generating_pattern.abstract_factory.Account;
import javay.main.model.generating_pattern.abstract_factory.Bank;
import javay.main.model.generating_pattern.abstract_factory.ICICIBank;
import javay.main.model.generating_pattern.abstract_factory.YesBank;

public class BankFactory extends AbstractFactory {

    final String ICICI_BANK = "ICICI";
    final String YES_BANK = "YES";

    @Override
    Bank getBank(String bankName) {
        switch (bankName) {
            case ICICI_BANK: return new ICICIBank();
            case YES_BANK: return new YesBank();
            default: return null;
        }
    }

    @Override
    Account getAccount(String accountType) {
        return null;
    }
}
