package javay.main.repository.impl;


import javay.main.model.CurrentAccount;
import javay.main.repository.AccountRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcAccountRepository implements AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CurrentAccount findByAccountId(Long accountId) {
       String sql = "SELECT * FROM Account WHERE id = " + accountId;
       return jdbcTemplate.queryForObject(sql, new RowMapper<CurrentAccount>() {
           @Override
           public CurrentAccount mapRow(ResultSet resultSet, int i) throws SQLException {
               CurrentAccount account = new CurrentAccount(accountId);
               account.setName(resultSet.getString("name"));
               account.setBalance(resultSet.getLong("balance"));
               return account;
           }
       });
    }

    @PreDestroy
    public void clearCache() {
        System.out.println("Called clearCache() method");
    }
}
