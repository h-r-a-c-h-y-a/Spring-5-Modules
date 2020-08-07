package am.gitc.dao.impl;

import am.gitc.dao.SingerDao;
import am.gitc.entities.Album;
import am.gitc.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PlainSingerDao implements SingerDao {

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Problem loading DB driver!", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/musicdb?useSSL=true",
                "postgres", "root");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Problem closing connection to the database!", e);
        }
    }

    private Set<Singer> createSingersFromDb(ResultSet rs, Set<Singer> singers) throws SQLException {
        Singer singer = null;
        one:while (rs.next()) {
            Long id = rs.getLong("s_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            LocalDate d = rs.getObject("birth_date", LocalDate.class);
            Album album = new Album(rs.getLong("singer_id"), rs.getString("title"), rs.getObject("release_date", LocalDate.class));
            album.setId(rs.getLong("album_id"));
            for (Singer s : singers) {
                if (s.getId().equals(id) && s.getId().equals(album.getSingerId())) {
                    s.getAlbums().add(album);
                    continue one;
                }
            }
            singer = new Singer(firstName, lastName, d);
            singer.setId(id);
            singer.setAlbums(new HashSet<>());
            if (singer.getId().equals(album.getSingerId()))
                singer.getAlbums().add(album);
            singers.add(singer);
        }
        return singers;
    }

    @Override
    public Set<Singer> findAll() {
        Set<Singer> result = new HashSet<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "select s.id as s_id, first_name, last_name, birth_date," +
                    " a.id as album_id, singer_id,  title, release_date" +
                    " from singer s left join album a on s.id = a.singer_id;");
            ResultSet rs = stmt.executeQuery();
            createSingersFromDb(rs, result);
            stmt.close();
        } catch (SQLException e) {
            logger.error("Problem when executing SELECT!", e);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public Set<Singer> findByFirstName(String firstName) {
        Set<Singer> result = new HashSet<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from singer where first_name = ?;");
            stmt.setString(1, firstName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                createSingersFromDb(rs,result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into singer(first_name, last_name, birth_date) values (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, singer.getFirstName());
            stmt.setString(2, singer.getLastName());
            stmt.setObject(3, singer.getBirthDate());
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) singer.setId(generatedKeys.getLong(1));
            stmt.close();
        } catch (SQLException e) {
            logger.error("Problem executing INSERT", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("update singer set first_name = ? ," +
                    " last_name = ? ," +
                    " birth_date = ?" +
                    " where id = ?");
            stmt.setString(1, singer.getFirstName());
            stmt.setString(2, singer.getLastName());
            stmt.setObject(3, singer.getBirthDate());
            stmt.setLong(4, singer.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("delete from singer where id = ?");
            stmt.setLong(1, singerId);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            logger.error("Problem executing DELETE", e);
        }
    }

    @Override
    public Set<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
