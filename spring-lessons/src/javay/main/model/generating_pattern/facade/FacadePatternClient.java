package javay.main.model.generating_pattern.facade;

public class FacadePatternClient {
    public static void main(String[] args) {
        BankingServiceFacade serviceFacade = new BankingServiceFacadeImpl();
        serviceFacade.moneyToTransfer();
    }
}
