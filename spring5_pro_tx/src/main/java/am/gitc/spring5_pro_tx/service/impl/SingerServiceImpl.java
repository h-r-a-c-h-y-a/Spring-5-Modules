package am.gitc.spring5_pro_tx.service.impl;

import am.gitc.spring5_pro_tx.entities.Singer;
import am.gitc.spring5_pro_tx.repository.SingerRepository;
import am.gitc.spring5_pro_tx.service.SingerService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);
    private final SingerRepository repository;

    public SingerServiceImpl(SingerRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public Singer save(Singer singer) {
        return repository.save(singer);
    }

    @Override
    public void delete(Singer singer) {
        repository.delete(singer);
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public long countAll() {
        return repository.countAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        return null;
    }
}
