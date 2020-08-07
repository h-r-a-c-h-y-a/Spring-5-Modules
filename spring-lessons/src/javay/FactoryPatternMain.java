package javay;

import javay.main.factory.AccountFactory;
import javay.main.factory.FactoryProducer;
import javay.main.model.generating_pattern.abstract_factory.Account;

public class FactoryPatternMain {
    public static void main(String[] args) {
        AccountFactory factory = (AccountFactory) FactoryProducer.getFactory("ACCOUNT");
        Account saving = factory.getAccount("SAVING");
        if (saving != null) saving.accountType();
        Account current = factory.getAccount("CURRENT");
        if (current != null) current.accountType();

    }
}
