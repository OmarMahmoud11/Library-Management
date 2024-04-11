package Library.Library.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import Library.Library.Controller.PatronController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Library.Library.Entities.Patron;
import Library.Library.Services.PatronServices;

public class PatronControllerTest {

    @Mock
    private PatronServices patronServices;

    @InjectMocks
    private PatronController patronController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAll() {
        List<Patron> patrons = new ArrayList<>();
        patrons.add(new Patron(1L, "John Doe", "john@example.com",null));
        patrons.add(new Patron(2L, "John Doe", "john@example.com",null));

        when(patronServices.retrieveAll()).thenReturn(patrons);

        List<Patron> result = patronController.retrieveAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        Patron patron = new Patron(1L, "John Doe", "john@example.com",null);

        when(patronServices.getById(1L)).thenReturn(patron);

        Patron result = patronController.getById(1L);

        assertNotNull(result);
    }

    @Test
    public void testAddPatron() {
        Patron patron = new Patron(1L, "John Doe", "john@example.com",null);

        when(patronServices.addPatron(patron)).thenReturn(true);

        ResponseEntity<String> response = patronController.addPatron(patron);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Add Patron success", response.getBody());
    }

    @Test
    public void testUpdatePatron() {
        Patron patron = new Patron(1L, "John Doe", "john@example.com",null);

        when(patronServices.updatePatron(1L, patron)).thenReturn(true);

        ResponseEntity<String> response = patronController.updatePatron(1L, patron);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Update Patron success", response.getBody());
    }

    @Test
    public void testDeletePatron() {
        when(patronServices.deletePatron(1L)).thenReturn(true);

        ResponseEntity<String> response = patronController.deletePatron(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Delete Patron success", response.getBody());
    }
}
