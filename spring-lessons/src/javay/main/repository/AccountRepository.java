package javay.main.repository;

import javay.main.model.Account;
import javay.main.model.CurrentAccount;

public interface AccountRepository {
    CurrentAccount findByAccountId(Long accountId);
}
