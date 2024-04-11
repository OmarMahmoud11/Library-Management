package Library.Library.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import Library.Library.Controller.BookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Library.Library.Entities.Book;
import Library.Library.Services.BookServices;

public class BookControllerTest {

    @Mock
    private BookServices bookServices;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null));
        books.add(new Book(2L, "Book 2", "Author 2", "2022", "ISBN-1234",null));

        when(bookServices.retrieveAll()).thenReturn(books);

        List<Book> result = bookController.retrieveAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Book book = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);

        when(bookServices.getById(1L)).thenReturn(book);

        Book result = bookController.getById(1L);

        assertNotNull(result);
    }

    @Test
    public void testAddBook() {
        Book book = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);

        when(bookServices.addBook(book)).thenReturn(true);

        ResponseEntity<String> response = bookController.addBook(book);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Add Book success", response.getBody());
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book(1L, "Book 1", "Author 1", "2022", "ISBN-1234",null);

        when(bookServices.updateBook(1L, book)).thenReturn(true);

        ResponseEntity<String> response = bookController.updateBook(1L, book);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Update Book success", response.getBody());
    }

    @Test
    public void testDeleteBook() {
        when(bookServices.deleteBook(1L)).thenReturn(true);

        ResponseEntity<String> response = bookController.deleteBook(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Delete Book success", response.getBody());
    }
}
