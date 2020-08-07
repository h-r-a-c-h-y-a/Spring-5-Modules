package am.gitc.web;

import am.gitc.entities.Singer;
import am.gitc.repository.ReactiveSingerRepo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class SingerHandler {

    private ReactiveSingerRepo singerRepo;

    public SingerHandler(ReactiveSingerRepo singerRepo) {
        this.singerRepo = singerRepo;
    }

    public HandlerFunction<ServerResponse> list = request ->
            ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(singerRepo.findAll(), Singer.class);


    public Mono<ServerResponse> show(ServerRequest request) {
        Mono<Singer> singerMono = singerRepo.findById(Long.valueOf(request.pathVariable("id")));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return singerMono.flatMap(singer -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(singer)))
                .switchIfEmpty(notFound);
    }

    public HandlerFunction<ServerResponse> save = request ->
            ServerResponse
                    .ok()
                    .build(singerRepo.save(request.bodyToMono(Singer.class)));

}
