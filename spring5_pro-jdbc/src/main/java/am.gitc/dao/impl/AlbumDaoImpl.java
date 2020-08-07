package am.gitc.dao.impl;

import am.gitc.dao.AlbumDao;
import am.gitc.entities.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class AlbumDaoImpl implements AlbumDao {

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

    @Override
    public void createAlbum(Album album) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into album(singer_id, title, release_date) values (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, album.getSingerId());
            stmt.setString(2, album.getTitle());
            stmt.setObject(3, album.getReleaseDate());
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) album.setId(generatedKeys.getLong(1));
            stmt.close();
        } catch (SQLException e) {
            logger.error("Problem executing INSERT", e);
        } finally {
            closeConnection(connection);
        }
    }
}
