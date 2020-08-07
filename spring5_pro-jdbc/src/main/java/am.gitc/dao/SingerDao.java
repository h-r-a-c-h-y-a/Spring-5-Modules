package am.gitc.dao;

import am.gitc.entities.Singer;

import java.util.Set;

public interface SingerDao {
    Set<Singer> findAll();

    Set<Singer> findByFirstName(String firstName);

    String findLastNameById(Long id);

    String findFirstNameById(Long id);

    void insert(Singer singer);

    void update(Singer singer);

    void delete(Long singerId);

    Set<Singer> findAllWithDetail();

    void insertWithDetail(Singer singer);
}
