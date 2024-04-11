package Library.Library.ServicesTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Library.Library.Entities.Book;
import Library.Library.Entities.BorrowingRecord;
import Library.Library.Entities.Patron;
import Library.Library.Repositories.BookRepository;
import Library.Library.Repositories.BorrowingRepository;
import Library.Library.Repositories.PatronRepository;
import Library.Library.Services.BorrowingServices;

public class BorrowingServicesTest {

    @Mock
    private BorrowingRepository borrowingRepository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private BorrowingServices borrowingServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddRecord() {
        Long bookId = 1L;
        Long patronId = 1L;

        Book book = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);
        Patron patron = new Patron(1L, "John Doe", "john@example.com",null);
        BorrowingRecord borrowingRecord = new BorrowingRecord();

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(patronRepository.findById(patronId)).thenReturn(Optional.of(patron));
        when(borrowingRepository.findByBookIdAndPatronId(bookId, patronId)).thenReturn(Optional.empty());
        when(borrowingRepository.save(any(BorrowingRecord.class))).thenReturn(borrowingRecord);

        borrowingServices.addRecord(bookId, patronId);

        verify(bookRepository, times(1)).findById(bookId);
        verify(patronRepository, times(1)).findById(patronId);
        verify(borrowingRepository, times(1)).findByBookIdAndPatronId(bookId, patronId);
        verify(borrowingRepository, times(1)).save(any(BorrowingRecord.class));
    }

    @Test
    public void testReturnBook() {
        Long bookId = 1L;
        Long patronId = 1L;

        BorrowingRecord borrowingRecord = new BorrowingRecord();

        when(borrowingRepository.findByBookIdAndPatronId(bookId, patronId)).thenReturn(Optional.of(borrowingRecord));

        borrowingServices.returnBook(bookId, patronId);

        verify(borrowingRepository, times(1)).findByBookIdAndPatronId(bookId, patronId);
        verify(borrowingRepository, times(1)).delete(borrowingRecord);
    }
}
