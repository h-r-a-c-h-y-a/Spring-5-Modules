package javay.main.service;

import javay.main.model.Amount;

public interface TransferService {
    void transfer(String accountA, String accountB, Long amount);
    void transferAmount(Long a, Long b, Amount amount);
    void createCache();
}
