package am.gitc.service;

import am.gitc.entities.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> getAll();
    List<Singer> getSinger(String firstName);
    String getSingerLastName(Long id);
    String getSingerFirstName(Long id);
    void create(Singer singer);
    void edit(Singer singer);
    void remove(Long singerId);
    List<Singer> getAllWithDetail();
    void createWithDetail(Singer singer);
}
