package am.gitc.service.impl;

import am.gitc.entities.Singer;
import am.gitc.repository.SingerRepository;
import am.gitc.service.JpaSingerService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaSingerService")
@Repository
@Transactional
public class SingerServiceJpaImpl implements JpaSingerService {

    private static final String ALL_SINGER_NATIVE_QUERY =
            "select id, first_name, last_name, birth_date, version from singer;";
    private static Logger logger = LoggerFactory.getLogger(SingerServiceJpaImpl.class);

    private final SingerRepository repository;

    public SingerServiceJpaImpl(SingerRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List<Singer> findAllWithAlbum() {
//        return em.createNamedQuery(Singer.FIND_ALL_WITH_ALBUM, Singer.class)
//                .getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Singer findById(Long id) {
//        return em.createNamedQuery(Singer.FIND_SINGER_BY_ID, Singer.class)
//                .setParameter("id", id).getSingleResult();
//    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

//    @Override
//    public Singer save(Singer singer) {
//        if (singer.getId() == null) {
//            logger.info("Inserting new singer");
//            em.persist(singer);
//        } else {
//            em.merge(singer);
//            logger.info("Updating existing singer");
//        }
//        logger.info("Singer saved with id: " + singer.getId());
//        return singer;
//    }
//
//    @Override
//    public void delete(Singer singer) {
//        singer = em.merge(singer);
//        em.remove(singer);
//        logger.info("Singer with id: " + singer.getId()
//                + "deleted successfully");
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<Singer> findAllByNativeQuery() {
//        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult")
//                .getResultList();
//    }
}
