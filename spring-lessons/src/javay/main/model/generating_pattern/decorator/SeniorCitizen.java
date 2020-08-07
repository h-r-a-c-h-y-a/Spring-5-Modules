package javay.main.model.generating_pattern.decorator;

public class SeniorCitizen extends AccountDecorator {
    private  Account account;

    public SeniorCitizen(Account account) {
        this.account = account;
    }

    @Override
    public String applyOtherBenefits() {
        return " an medical insurance of up to $1,000 for Senior " +
                "Citizen";
    }

    @Override
    public String getTotalBenefits() {
        return account.getTotalBenefits() + " other benefits are "
                + applyOtherBenefits();
    }
}
