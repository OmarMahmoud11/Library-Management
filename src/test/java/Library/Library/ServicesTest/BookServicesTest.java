package Library.Library.ServicesTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Library.Library.Entities.Book;
import Library.Library.Repositories.BookRepository;
import Library.Library.Services.BookServices;
public class BookServicesTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServices bookServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null));
        books.add(new Book(2L, "Book 2", "Author 2", "2023", "ISBN-5678",null));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookServices.retrieveAll();

        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
        assertEquals("Book 2", result.get(1).getTitle());
    }

    @Test
    public void testGetById() {
        Book book = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookServices.getById(1L);

        assertNotNull(result);
        assertEquals("Book 1", result.getTitle());
    }

    @Test
    public void testAddBook() {
        Book book = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);

        assertTrue(bookServices.addBook(book));
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdateBook() {
        Book existingBook = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);
        Book newBook = new Book(1L, "New Book", "New Author", "2023", "ISBN-5678",null);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));

        assertTrue(bookServices.updateBook(1L, newBook));
        verify(bookRepository, times(1)).updateById(newBook.getTitle(), newBook.getAuthor(), newBook.getPublicationYear(), newBook.getISBN(), 1L);
    }

    @Test
    public void testDeleteBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(new Book(1L, "New Book", "New Author", "2023", "ISBN-5678",null)));

        assertTrue(bookServices.deleteBook(1L));
        verify(bookRepository, times(1)).deleteById(1L);
    }
}
