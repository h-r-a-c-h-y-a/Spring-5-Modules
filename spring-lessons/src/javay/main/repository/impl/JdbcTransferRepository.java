package javay.main.repository.impl;


import javay.main.model.Account;
import javay.main.model.Amount;
import javay.main.repository.TransferRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class JdbcTransferRepository implements TransferRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTransferRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void transfer(Account accountA, Account accountB, Amount amount) {
        System.out.println("Transfering amount from account A to B via " +
                "JDBC implementation");
    }

    @PostConstruct
    public void populateCache() {
        System.out.println("Called populateCache() method");
    }
}
