package am.gitc.dao.impl;

import am.gitc.dao.SingerDao;
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
            Class.forName("org.postgresql.Dr");
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

    private Singer createSingerFromDb(ResultSet rs) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setLastName(rs.getString("last_name"));
        singer.setBirthDate(rs.getObject("birth_date", LocalDate.class));
        return singer;
    }

    @Override
    public Set<Singer> findAll() {
        Set<Singer> result = new HashSet<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from singer;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(createSingerFromDb(rs));
            }
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
                result.add(createSingerFromDb(rs));
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
                    "insert into singer(first_name, last_name, birth_day) values (?, ?, ?);",
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
