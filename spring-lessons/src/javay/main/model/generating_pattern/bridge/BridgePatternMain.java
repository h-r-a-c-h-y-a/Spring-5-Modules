package javay.main.model.generating_pattern.bridge;

public class BridgePatternMain {
    public static void main(String[] args) {
        Bank icici = new ICICIBank(new CurrentAccount());
        Account current = icici.openAccount();
        current.accountType();
        Bank hdfc = new HdfcBank(new SavingAccount());
        Account savingAccount = hdfc.openAccount();
        savingAccount.accountType();
    }
}
