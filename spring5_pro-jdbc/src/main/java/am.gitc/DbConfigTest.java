package am.gitc;

import am.gitc.entities.Album;
import am.gitc.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;

public class DbConfigTest {
    private static Logger logger = LoggerFactory.getLogger(DbConfig.class);

    public static void main(String[] args) throws SQLException {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:static/db/drivermanager-cfg-02.xml");
//        ctx.refresh();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("datasource", DataSource.class);
        testDataSource(dataSource);
    }

    private static void testDataSource(DataSource dataSource) throws SQLException {
        Connection connection = null;
        Singer singer = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("select s.id as s_id, first_name, last_name, birth_date,\n" +
                            "                     a.id as album_id, singer_id,  title, release_date\n" +
                            "                     from singer s inner join album a on s.id = ? and s.id = a.singer_id;");
            statement.setLong(1, 1L);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("s_id");
                String fN = resultSet.getString("first_name");
                String lN = resultSet.getString("last_name");
                LocalDate bd = resultSet.getObject("birth_date", LocalDate.class);
                singer = new Singer(fN, lN, bd);
                singer.setId(id);
                singer.setAlbums(new HashSet<>());
                Album album = new Album(
                        resultSet.getLong("singer_id"),
                        resultSet.getString("title"),
                        resultSet.getObject("release_date", LocalDate.class));
                album.setId(resultSet.getLong("album_id"));
                singer.getAlbums().add(album);
                while (resultSet.next()) {
                    album = new Album(
                            resultSet.getLong("singer_id"),
                            resultSet.getString("title"),
                            resultSet.getObject("release_date", LocalDate.class));
                    album.setId(resultSet.getLong("album_id"));
                    singer.getAlbums().add(album);
                }
                System.out.println(singer);
                statement.close();
            }
        } catch (Exception е) {
            logger.debug("Something unexpected happened.", е);
        } finally {
            if (connection != null)
                connection.close();
        }
    }
}
