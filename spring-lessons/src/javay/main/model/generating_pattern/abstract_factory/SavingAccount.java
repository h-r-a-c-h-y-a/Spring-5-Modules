package javay.main.model.generating_pattern.abstract_factory;

public class SavingAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("SAVING ACCOUNT");
    };
}
