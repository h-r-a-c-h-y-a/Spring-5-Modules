package am.gitc;

import am.gitc.config.JpaConfig;
import am.gitc.entities.Album;
import am.gitc.entities.Singer;
import am.gitc.service.JpaSingerService;
import am.gitc.service.SingerService;
import am.gitc.service.impl.SingerSummaryUntypedImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SpringJpaDemo {

    private static Logger logger = LoggerFactory.getLogger(SpringJpaDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:app-context-annotation.xml");
//        ctx.refresh();
//        SingerSummaryUntypedImpl untyped = ctx.getBean(SingerSummaryUntypedImpl.class);
        JpaSingerService singerService = ctx.getBean(JpaSingerService.class);
//        insertSinger(singerService);
        List<Singer> singer = singerService.findByFirstName("John");
        singer.forEach(singer1 -> logger.info(singer1.toString()));
//        singerService.delete(singer);
        listSingers(singerService.findAll());
//        untyped.displayAllSingerSummary();
        ctx.close();
    }

    private static void insertSinger(SingerService singerService) {
        Singer singer = new Singer();
        singer.setFirstName("Ariana");
        singer.setLastName("Grande");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1993, 6, 11))
                        .getTime ().getTime ()));
        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date(
                (new GregorianCalendar(2018, 7, 18))
                        .getTime().getTime()));
        singer.addAlbum(album);
        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date(
                (new GregorianCalendar(2018, 3, 20))
                        .getTime().getTime ()));
        singer.addAlbum(album);
        singerService.save(singer);
        logger.info(singer.toString());
        singerService.delete(singer);
    }

    private static void listSingers(List<Singer> singers) {
        for(Singer singer : singers) {
            logger.info(singer.toString());
        }
    }
}
