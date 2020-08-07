package am.gitc.spring5_pro_tx.service;

import am.gitc.spring5_pro_tx.entities.Album;
import am.gitc.spring5_pro_tx.entities.Singer;

import java.util.List;

public interface AlbumService {
    List<Album> findBySinger(Singer singer);
    List<Album> findByTitle(String title);
}
