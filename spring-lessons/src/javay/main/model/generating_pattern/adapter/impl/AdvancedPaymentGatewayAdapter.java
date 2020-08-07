package javay.main.model.generating_pattern.adapter.impl;

import javay.main.model.generating_pattern.abstract_factory.Account;
import javay.main.model.generating_pattern.adapter.AdvancedPayGateway;
import javay.main.model.generating_pattern.adapter.PaymentGateway;

public class AdvancedPaymentGatewayAdapter implements AdvancedPayGateway {

    private PaymentGateway paymentGateway;

    public AdvancedPaymentGatewayAdapter(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }



    @Override
    public void makePayment(String mob1, String mob2) {
        Account account1 = null;
        Account account2 = null;
        paymentGateway.doPayment(account1, account2);
    }
}
