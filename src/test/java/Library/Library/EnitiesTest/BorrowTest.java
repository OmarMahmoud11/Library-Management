package Library.Library.EnitiesTest;

import Library.Library.Entities.Book;
import Library.Library.Entities.BorrowingRecord;
import Library.Library.Entities.Patron;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class BorrowTest {
    @Test
    public void classTest(){
        Patron patron = new Patron(1L,"name","contact",null);
        Book book = new Book(1L,"title","author","publicationYear","isbn",null);
        Date returnDate = Date.valueOf(LocalDate.now().plus(2, ChronoUnit.WEEKS));
        BorrowingRecord borrowingRecord = new BorrowingRecord(1L,patron,book,returnDate);
        Assertions.assertThat(borrowingRecord.getPatron()).isEqualTo(patron);
        Assertions.assertThat(borrowingRecord.getBook()).isEqualTo(book);
        Assertions.assertThat(borrowingRecord.getReturnDate()).isEqualTo(returnDate);
        Assertions.assertThat(borrowingRecord.getId()).isEqualTo(1);
        borrowingRecord.setId(5L);
    }
}
