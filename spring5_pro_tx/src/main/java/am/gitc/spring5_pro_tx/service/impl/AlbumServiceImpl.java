package am.gitc.spring5_pro_tx.service.impl;

import am.gitc.spring5_pro_tx.entities.Album;
import am.gitc.spring5_pro_tx.entities.Singer;
import am.gitc.spring5_pro_tx.repository.AlbumRepository;
import am.gitc.spring5_pro_tx.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaAlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository repository;

    public AlbumServiceImpl(AlbumRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Album> findBySinger(Singer singer) {
        return repository.findBySinger(singer);
    }

    @Override
    public List<Album> findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
