package javay.main.dao;

import javay.main.model.Acount;

import java.util.List;

public interface AccountDao {
    Integer totalAccountsByBranch(String branch);
    Acount findOne(long accountId);
    void removeOne(long accountId);
    Acount findByName(String name);
    List<Acount> findAllAccountInBranch(String branchName);
    void saveAccount(Acount acount);
}
