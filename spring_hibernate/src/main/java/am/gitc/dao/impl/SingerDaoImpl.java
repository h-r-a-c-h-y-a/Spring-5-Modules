package am.gitc.dao.impl;

import am.gitc.dao.SingerDao;
import am.gitc.entities.Singer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository("singerDao")
@Transactional
public class SingerDaoImpl implements SingerDao {

    @Resource(name = "sessionFactory")
    private final SessionFactory sessionFactory;

    @Autowired
    public SingerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Singer s").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Singer.findAllWithAlbum")
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession()
                .getNamedQuery("Singer.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Singer save(Singer contact) {
         sessionFactory.getCurrentSession()
                .saveOrUpdate(contact);
         return contact;
    }

    @Override
    public void delete(Singer contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }
}
