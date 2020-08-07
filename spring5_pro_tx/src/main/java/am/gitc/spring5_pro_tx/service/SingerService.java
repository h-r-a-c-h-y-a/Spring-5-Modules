package am.gitc.spring5_pro_tx.service;

import am.gitc.spring5_pro_tx.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    long countAll();

    List<Singer> findAllByNativeQuery();
}
