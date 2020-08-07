package am.gitc.spring5_boot_mvc.service;


import am.gitc.spring5_boot_mvc.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();

    Singer findById(long id);

    Singer save(Singer singer);

    void delete(Singer singer);
}
