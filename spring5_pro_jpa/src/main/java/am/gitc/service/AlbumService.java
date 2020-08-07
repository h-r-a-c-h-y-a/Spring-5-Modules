package am.gitc.service;

import am.gitc.entities.Album;
import am.gitc.entities.Singer;

import java.util.List;

public interface AlbumService {
    List<Album> findBySinger(Singer singer);
    List<Album> findByTitle(String title);
}
