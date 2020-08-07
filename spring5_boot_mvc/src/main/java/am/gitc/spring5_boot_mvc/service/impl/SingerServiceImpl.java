package am.gitc.spring5_boot_mvc.service.impl;

import am.gitc.spring5_boot_mvc.entities.Singer;
import am.gitc.spring5_boot_mvc.repository.SingerRepository;
import am.gitc.spring5_boot_mvc.service.SingerService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service
public class SingerServiceImpl implements SingerService {

    private final SingerRepository repository;

    @Autowired
    public SingerServiceImpl(SingerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Singer findById(long id) {
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

    @PostConstruct
    public void init() throws IOException {
        Set<Singer> singers = new HashSet<>();
        singers.add(new Singer("John", "Mayer", new Date(new GregorianCalendar(1977, 10, 16)
                .getTime().getTime()), "A wonderful voice"));
        singers.add(new Singer("Eric", "Clapton", new Date(new GregorianCalendar(1945, 3, 30)
                .getTime().getTime()), "A wonderful voice"));
        singers.add(new Singer("John", "Butler", new Date(new GregorianCalendar(1964, 11, 11)
                .getTime().getTime()), "A wonderful voice"));
        singers.forEach(repository::save);
    }
}
