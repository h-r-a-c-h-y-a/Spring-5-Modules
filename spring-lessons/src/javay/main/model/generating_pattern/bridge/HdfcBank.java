package javay.main.model.generating_pattern.bridge;

public class HdfcBank extends Bank {

    public HdfcBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.print("Open your account with Hdfc Bank");
        return account;
    }
}
