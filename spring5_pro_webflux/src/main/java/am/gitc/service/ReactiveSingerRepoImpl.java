package am.gitc.service;

import am.gitc.entities.Singer;
import am.gitc.repository.ReactiveSingerRepo;
import am.gitc.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveSingerRepoImpl implements ReactiveSingerRepo {

    private final SingerRepository repository;

    @Autowired
    public ReactiveSingerRepoImpl(SingerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Singer> findById(Long id) {
        return Mono.justOrEmpty(repository.findById(id));
    }

    @Override
    public Flux<Singer> findAll() {
        return Flux.fromIterable(repository.findAll());
    }

    @Override
    public Mono<Void> save(Mono<Singer> singerMono) {
        return singerMono.doOnNext(repository::save
        ).thenEmpty(Mono.empty());
    }
}
