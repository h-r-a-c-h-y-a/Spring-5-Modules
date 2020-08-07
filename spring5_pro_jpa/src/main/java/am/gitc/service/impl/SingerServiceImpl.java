package am.gitc.service.impl;

import am.gitc.entities.Singer;
import am.gitc.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

    private static final String ALL_SINGER_NATIVE_QUERY =
            "select id, first_name, last_name, birth_date, version from singer;";
    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return em.createNamedQuery(Singer.FIND_ALL, Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return em.createNamedQuery(Singer.FIND_ALL_WITH_ALBUM, Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return em.createNamedQuery(Singer.FIND_SINGER_BY_ID, Singer.class)
                .setParameter("id", id).getSingleResult();
    }


    @Override
    public Singer save(Singer singer) {
        if (singer.getId() == null) {
            logger.info("Inserting new singer");
            em.persist(singer);
        } else {
            em.merge(singer);
            logger.info("Updating existing singer");
        }
        logger.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        singer = em.merge(singer);
        em.remove(singer);
        logger.info("Singer with id: " + singer.getId()
                + "deleted successfully");
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult")
                .getResultList();
    }
}
