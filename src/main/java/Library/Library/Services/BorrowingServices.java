package Library.Library.Services;

import Library.Library.Entities.Book;
import Library.Library.Entities.BorrowingRecord;
import Library.Library.Entities.Patron;
import Library.Library.Repositories.BookRepository;
import Library.Library.Repositories.BorrowingRepository;
import Library.Library.Repositories.PatronRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Transactional
@Service
public class BorrowingServices {
    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PatronRepository patronRepository;

    public void addRecord(Long bookId,Long patronId){
        if(borrowingRepository.findByBookIdAndPatronId(bookId,patronId).isPresent()) {
            throw new RuntimeException("The patron already borrow this book");
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));

        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new EntityNotFoundException("Patron not found with id: " + patronId));

        Date returnDate = Date.valueOf(LocalDate.now().plus(2, ChronoUnit.WEEKS));
        BorrowingRecord borrowingRecord = BorrowingRecord.builder()
                .book(book)
                .patron(patron)
                .returnDate(returnDate)
                .build();
        borrowingRepository.save(borrowingRecord);
    }
    public void returnBook(Long bookId,Long patronId){
        BorrowingRecord borrowingRecord = borrowingRepository.findByBookIdAndPatronId(bookId,patronId).orElseThrow(() -> new EntityNotFoundException("Borrowing record not found for bookId: " + bookId + " and patronId: " + patronId));
        borrowingRepository.delete(borrowingRecord);
    }
}
