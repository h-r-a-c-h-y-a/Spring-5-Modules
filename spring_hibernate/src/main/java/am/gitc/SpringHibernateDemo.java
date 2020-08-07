package am.gitc;

import am.gitc.config.HbmConfig;
import am.gitc.dao.SingerDao;
import am.gitc.entities.Album;
import am.gitc.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SpringHibernateDemo {

    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(HbmConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        insertSinger(singerDao);
        listSingers(singerDao.findAllWithAlbum());
        Singer singer = singerDao.findById(2L);
        logger.info(singer.toString());
    }

    private static void insertSinger(SingerDao singerDao) {
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
        singerDao.save(singer);
        logger.info(singer.toString());
        singerDao.delete(singer);
    }

    private static void listSingers(List<Singer> singers) {
        for(Singer singer : singers) {
            logger.info(singer.toString());
        }
    }
}
