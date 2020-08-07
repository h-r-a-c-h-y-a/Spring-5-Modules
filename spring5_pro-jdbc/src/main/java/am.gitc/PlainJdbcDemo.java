package am.gitc;

import am.gitc.dao.AlbumDao;
import am.gitc.dao.SingerDao;
import am.gitc.dao.impl.AlbumDaoImpl;
import am.gitc.dao.impl.PlainSingerDao;
import am.gitc.entities.Album;
import am.gitc.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class PlainJdbcDemo {
    private static SingerDao singerDao = new PlainSingerDao();
    private static AlbumDao albumDao = new AlbumDaoImpl();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        logger.info("Listing initial singer data:");
//        insertSingersAndAlbums();
        listAllSingers();
        logger.info("-------------");
        logger.info("Insert а new singer");
        Singer singer = new Singer("Ed", "Sheeran", LocalDate.of(1991, 2, 2));
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


    private static void insertSingersAndAlbums() {
        Set<Singer> singers = new HashSet<>();
        singers.add(new Singer("John", "Mayer", LocalDate.of(1977, 10, 16)));
        singers.add(new Singer("Eric", "Clapton", LocalDate.of(1945, 3, 30)));
        singers.add(new Singer("John", "Butler", LocalDate.of(1975, 4, 1)));
        Set<Album> albums = new HashSet<>();
        albums.add(new Album( 1L, "The Search For Everything", LocalDate.of(2009, 11, 17)));
        albums.add(new Album( 1L, "Battle Studies", LocalDate.of(2009, 11, 17)));
        albums.add(new Album( 2L, " From The Cradle", LocalDate.of(1994, 9, 13)));
        singers.forEach(singer -> singerDao.insert(singer));
        albums.forEach(album -> albumDao.createAlbum(album));
    }

    private static void listAllSingers() {
        Set<Singer> singers = singerDao.findAll();
        singers.forEach(singer -> logger.info(singer.toString()));
    }
}
