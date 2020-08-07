package am.gitc.repository;

import am.gitc.entities.Album;
import am.gitc.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("select a from Album a where a.title like %:title%")
    List<Album> findByTitle(@Param("title") String title);

    List<Album> findBySinger(Singer singer);
}
