package javay.main.model.generating_pattern.decorator;

public class Privilege extends AccountDecorator {
    private  Account account;

    public Privilege(Account account) {
        this.account = account;
    }

    @Override
    public String applyOtherBenefits() {
        return " an accident insurance of up to $1,600 and " +
            "an overdraft facility of $84";
    }

    @Override
    public String getTotalBenefits() {
        return account.getTotalBenefits() + " other benefits are "
                + applyOtherBenefits();
    }
}
