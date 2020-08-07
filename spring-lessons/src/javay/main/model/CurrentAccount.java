package javay.main.model;

public class CurrentAccount implements Account {
    private Long accountId;
    private String name;
    private Long balance;

    private Amount amount;

    public CurrentAccount(Long accountId) {

        this.accountId = accountId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public void accountType() {
        System.out.println("CURRENT ACCOUNT");
    }
}
