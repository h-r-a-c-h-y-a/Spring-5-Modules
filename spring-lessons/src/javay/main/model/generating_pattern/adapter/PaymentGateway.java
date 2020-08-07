package javay.main.model.generating_pattern.adapter;

import javay.main.model.generating_pattern.abstract_factory.Account;

public interface PaymentGateway {
    void doPayment(Account account1, Account account2);
}
