package am.gitc.service;

import am.gitc.entities.Singer;

import java.util.List;

public interface JpaSingerService {
    List<Singer> findAll();
//    List<Singer> findAllWithAlbum();
//    Singer findById(Long id);
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
//    Singer save(Singer singer);
//    void delete(Singer singer);
//    List<Singer> findAllByNativeQuery();
}
