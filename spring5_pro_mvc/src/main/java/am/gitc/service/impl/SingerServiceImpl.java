package am.gitc.service.impl;

import am.gitc.entities.Singer;
import am.gitc.repository.SingerRepository;
import am.gitc.service.SingerService;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

@Transactional
@Service("singerService")
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
    public Singer findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer, Part file) {
        if (file != null) {
            logger.info("File name: " + file.getName());
            logger.info("File size: " + file.getSize());
            logger.info("File content type: " + file.getContentType());
            byte[] fileContent = null;
            try {
                InputStream in = file.getInputStream();
                if (in == null) logger.info("File inputStream is null");
                singer.setPhoto(IOUtils.toByteArray(in));

            } catch (IOException e) {
               logger.error("Error saving upload file");
            }
        }
        return repository.save(singer);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Singer> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostConstruct
    public void init() throws IOException {
        Set<Singer> singers = new HashSet<>();
        singers.add(new Singer("John", "Mayer", new Date(new GregorianCalendar(1977, 10, 16)
                .getTime().getTime()), "A wonderful voice", Files.readAllBytes(Path.of("C:\\Users\\Hrach\\IdeaProjects\\spring5_pro_mvc\\src\\main\\webapp\\images\\Penguins.jpg"))));
        singers.add(new Singer("Eric", "Clapton", new Date(new GregorianCalendar(1945, 3, 30)
                .getTime().getTime()), "A wonderful voice", Files.readAllBytes(Path.of("C:\\Users\\Hrach\\IdeaProjects\\spring5_pro_mvc\\src\\main\\webapp\\images\\Koala.jpg"))));
        singers.add(new Singer("John", "Butler", new Date(new GregorianCalendar(1964, 11, 11)
                .getTime().getTime()), "A wonderful voice", Files.readAllBytes(Path.of("C:\\Users\\Hrach\\IdeaProjects\\spring5_pro_mvc\\src\\main\\webapp\\images\\Chrysanthemum.jpg"))));
        singers.forEach(repository::save);
    }
}
