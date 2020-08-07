package javay.main.factory;

public class FactoryProducer {
    final static String BANK = "BANK";
    final static String ACCOUNT = "ACCOUNT";

    public static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equalsIgnoreCase(BANK)) return new BankFactory();
        else if (factoryName.equalsIgnoreCase(ACCOUNT)) return new AccountFactory();
        else return null;
    }
}
