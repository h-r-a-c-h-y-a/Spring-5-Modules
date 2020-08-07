package am.gitc;

import am.gitc.dao.SingerDao;
import am.gitc.dao.impl.PlainSingerDao;
import am.gitc.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class PlainJdbcDemo {
    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        logger.info("Listing initial singer data:");
        listAllSingers();
        logger.info("-------------");
        logger.info("Insert а new singer");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(LocalDate.of(1991, 2, 2));
        singerDao.insert(singer);
        logger.info("Listing singer data "
                + "after new singer created:");
        listAllSingers();
        logger.info("-------------");
        logger.info("Deleting the previous created singer");
        singerDao.delete(singer.getId());
        logger.info("Listing singer data "
                + "after new singer deleted:");
        listAllSingers();
    }

    private static void listAllSingers() {
        Set<Singer> singers = singerDao.findAll();
        singers.forEach(singer -> logger.info(singer.toString()));
    }
}
