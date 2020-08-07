package am.gitc.spring5_boot_mvc.repository;

import am.gitc.spring5_boot_mvc.entities.Singer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Long> {
}
