package am.gitc.spring5_pro_tx;

import am.gitc.spring5_pro_tx.entities.Singer;
import am.gitc.spring5_pro_tx.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Spring5ProTxApplication {

    private static Logger logger = LoggerFactory.getLogger(Spring5ProTxApplication.class);
    public static void main(String[] args) {
      ConfigurableApplicationContext ctx = SpringApplication.run(Spring5ProTxApplication.class, args);
        SingerService service = ctx.getBean(SingerService.class);
        List<Singer> singers = service.findAll();
        singers.forEach(singer -> logger.info(singer.toString()));

        Singer singer = service.findById(1L);
        singer.setFirstName("John Clayton");
        singer.setLastName("Mayer");
        singer = service.save(singer);
        System.out.println("Singer saved successfully: " + singer);
        logger.info("count of all singers: " + service.countAll());
        ctx.close();
    }

}
