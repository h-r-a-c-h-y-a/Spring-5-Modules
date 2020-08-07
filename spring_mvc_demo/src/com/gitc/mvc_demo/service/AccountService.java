package com.gitc.mvc_demo.service;

import com.gitc.mvc_demo.model.Account;

import java.util.List;

public interface AccountService {
    void open(Account account);
    List<Account> findAll();
    Account findOne(long id);
}
