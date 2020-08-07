package javay.main.model.generating_pattern.facade;

public class BankingServiceFacadeImpl implements BankingServiceFacade{

    @Override
    public void moneyToTransfer() {
        if (PaymentService.doPayment()) {
            Account from = AccountService.getAccount("1");
            Account to = AccountService.getAccount("2");
            TransferService.transfer(1000, from, to);
        }
    }
}
