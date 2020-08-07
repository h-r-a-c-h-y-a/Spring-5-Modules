package javay.main.dao.impl;

import javay.main.dao.AccountDao;
import javay.main.model.Account;
import javay.main.model.Acount;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
//    @Override
//    public Integer totalAccountsByBranch(String branch) {
//       String sql = "SELECT COUNT(*) FROM Account WHERE branch_name = " + branch;
//        return getJdbcTemplate().queryForObject(sql, Integer.class);
//    }
//}

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    private final SessionFactory sessionFactory;

    public AccountDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Cacheable("acountCache")
    public Integer totalAccountsByBranch(String branch) {
        String sql = "SELECT COUNT(*) FROM Acount WHERE branch_name = " + branch;
        return sessionFactory.getCurrentSession()
                .createQuery(sql, Integer.class).getSingleResult();
    }

    @Cacheable(cacheNames = "acountCache",
            key = "#accountId",
            condition = "#accountId >= 2000",
            unless = "#result.branchName.contains('first')")
    @Override
    public Acount findOne(long accountId) {
        return sessionFactory.getCurrentSession().get(Acount.class, accountId);
    }

    @Override
    @CacheEvict(value = "acountCache",
            key = "#accountId")
    public void removeOne(long accountId) {

    }

    @Override
    public Acount findByName(String name) {
        return (Acount) sessionFactory.getCurrentSession().createCriteria(Account.class)
                .add(Restrictions.eq("name", name))
                .list().get(0);
    }

    @Override
    public List<Acount> findAllAccountInBranch(String branchName) {
        return sessionFactory.getCurrentSession().createCriteria(Acount.class)
                .add(Restrictions.eq("branchName", branchName)).list();
    }

    @Override
    @CachePut(value = "acountCache", key = "#acount.id")
    public void saveAccount(Acount acount) {
        sessionFactory.getCurrentSession().save(acount);
    }
}
