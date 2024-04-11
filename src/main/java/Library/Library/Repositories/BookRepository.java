package Library.Library.Repositories;

import Library.Library.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Modifying
    @Query("""
            UPDATE Book b
            SET b.title = (?1), b.author = (?2), b.publicationYear= (?3), b.ISBN = (?4)
            WHERE b.id = (?5)""")
    void updateById(String title,String author,String publicationYear,String isbn,Long id);
}

