package am.gitc;

import am.gitc.entities.Singer;
import am.gitc.repository.ReactiveSingerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.io.IOException;
import java.time.Duration;

@Controller
@SpringBootApplication
public class ReactiveApp {

    private static Logger logger = LoggerFactory.getLogger(ReactiveApp.class);

    private final ReactiveSingerRepo singerRepo;

    public ReactiveApp(ReactiveSingerRepo singerRepo) {
        this.singerRepo = singerRepo;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Singer> oneByOne() {
        Flux<Singer> singers = singerRepo.findAll();
        Flux<Long> periodFlux = Flux.interval(Duration.ofSeconds(2));
        return Flux.zip(singers, periodFlux).map(Tuple2::getT1);
    }

    @GetMapping("/one/{id}")
    public Mono<Singer> one(@PathVariable Long id) {
        return singerRepo.findById(id);
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ReactiveApp.class, args);
        assert (ctx != null);
        logger.info("Application started . . . ");
        System.in.read();
        ctx.close();
    }
}
