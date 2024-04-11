package Library.Library.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import Library.Library.Controller.BorrowingController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Library.Library.Services.BorrowingServices;

public class BorrowingControllerTest {

    @Mock
    private BorrowingServices borrowingServices;

    @InjectMocks
    private BorrowingController borrowingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBorrowBook() {
        Long bookId = 1L;
        Long patronId = 1L;

        ResponseEntity<String> response = borrowingController.borrowBook(bookId, patronId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book borrowed successfully", response.getBody());
        verify(borrowingServices, times(1)).addRecord(bookId, patronId);
    }

    @Test
    public void testReturnBook() {
        Long bookId = 1L;
        Long patronId = 1L;

        ResponseEntity<String> response = borrowingController.returnBook(bookId, patronId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book returned successfully", response.getBody());
        verify(borrowingServices, times(1)).returnBook(bookId, patronId);
    }
}

