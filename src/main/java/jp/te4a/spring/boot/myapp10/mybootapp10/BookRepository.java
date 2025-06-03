package jp.te4a.spring.boot.myapp10.mybootapp10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer> {
    @Query("SELECT x FROM BookBean x ORDER BY x.title")

    List<BookBean> findAllOrderByTitle();
}
