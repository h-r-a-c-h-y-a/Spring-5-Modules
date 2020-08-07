package javay.main.model.generating_pattern.adapter.impl;

import javay.main.model.generating_pattern.abstract_factory.Account;
import javay.main.model.generating_pattern.adapter.PaymentGateway;

public class PaymentGatewayImpl implements PaymentGateway {
    @Override
    public void doPayment(Account account1, Account account2) {
        System.out.println("Do payment using Payment Gateway");
    }
}
