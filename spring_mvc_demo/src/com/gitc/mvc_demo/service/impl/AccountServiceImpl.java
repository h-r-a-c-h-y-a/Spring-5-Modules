package com.gitc.mvc_demo.service.impl;

import com.gitc.mvc_demo.model.Account;
import com.gitc.mvc_demo.repository.AccountRepository;
import com.gitc.mvc_demo.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void open(Account account) {
         accountRepository.saveAccount(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findOne(long id) {
        return accountRepository.findOne(id);
    }
}
