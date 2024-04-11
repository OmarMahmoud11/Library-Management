package Library.Library.EnitiesTest;

import Library.Library.Entities.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
    @Test
    public void classTest(){
        Book book = new Book(1L,"title","author","publicationYear","isbn",null);
        Assertions.assertThat(book.getTitle()).isEqualTo("title");
        Assertions.assertThat(book.getId()).isEqualTo(1);
        Assertions.assertThat(book.getAuthor()).isEqualTo("author");
        Assertions.assertThat(book.getPublicationYear()).isEqualTo("publicationYear");
        Assertions.assertThat(book.getISBN()).isEqualTo("isbn");
        book.setAuthor("author2");
        book.setISBN("isbn2");
        book.setId(5L);
    }
}
