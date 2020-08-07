package com.gitc.mvc_demo.repository;

import com.gitc.mvc_demo.model.Account;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AccountRepository {

    private final SessionFactory sessionFactory;

    public AccountRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Account findOne(long accountId) {
        return sessionFactory.getCurrentSession().get(Account.class, accountId);
    }

    public void removeOne(long accountId) {

    }

    public Account findByName(String name) {
        return (Account) sessionFactory.getCurrentSession().createCriteria(Account.class)
                .add(Restrictions.eq("name", name))
                .list().get(0);
    }


    public List<Account> findAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Account.class)
                .list();
    }


    public void saveAccount(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }
}

