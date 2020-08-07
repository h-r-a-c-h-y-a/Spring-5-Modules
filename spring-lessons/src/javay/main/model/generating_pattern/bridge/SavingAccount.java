package javay.main.model.generating_pattern.bridge;

public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("OPENED: SAVING ACCOUNT ");
        return new SavingAccount();
    }

    @Override
    public void accountType() {
        System.out.println("##It is a SAVING Account##");
    };
}
