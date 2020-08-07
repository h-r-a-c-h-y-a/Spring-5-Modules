package javay.main.repository;

import javay.main.model.Account;
import javay.main.model.Amount;

public interface TransferRepository {
    void transfer(Account accountA, Account accountB, Amount amount);
}
