package am.gitc.service;

import am.gitc.entities.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.Part;
import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(long id);
    Singer save(Singer singer, Part file);
    Page<Singer> findAllByPage(Pageable pageable);
}
