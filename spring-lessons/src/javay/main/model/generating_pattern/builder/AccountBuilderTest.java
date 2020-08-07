package javay.main.model.generating_pattern.builder;

public class AccountBuilderTest {
    public static void main(String[] args) {
        Account account = new Account
                .AccountBuilder("Neovision", 7007L, "bassen")
                .balance(23.8).build();
        System.out.println(account);
    }
}
