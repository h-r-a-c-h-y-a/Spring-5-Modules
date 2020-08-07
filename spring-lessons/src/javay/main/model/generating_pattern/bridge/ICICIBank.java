package javay.main.model.generating_pattern.bridge;

public class ICICIBank extends Bank {

    public ICICIBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.print("Open your account with ICICI Bank");
        return account;
    }
}
