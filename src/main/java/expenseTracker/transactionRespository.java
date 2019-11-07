package expenseTracker;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface transactionRespository extends JpaRepository<transaction, Integer> {

    // custom query to search to blog post by title or content
//    List<transaction> findByTitleContainingOrContentContaining(String text, String textAgain);

    @Query(value = "SELECT * from transaction order by created_at DESC limit 10 ",
            nativeQuery=true
    )
    List<transaction> selectTopTen();
}