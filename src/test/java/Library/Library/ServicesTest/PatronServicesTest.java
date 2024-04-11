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

import Library.Library.Entities.Patron;
import Library.Library.Repositories.PatronRepository;
import Library.Library.Services.PatronServices;

public class PatronServicesTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronServices patronServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAll() {
        List<Patron> patrons = new ArrayList<>();
        patrons.add(new Patron(1L, "John Doe", "john@example.com",null));
        patrons.add(new Patron(2L, "Jane Smith", "jane@example.com",null));

        when(patronRepository.findAll()).thenReturn(patrons);

        List<Patron> result = patronServices.retrieveAll();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Smith", result.get(1).getName());
    }

    @Test
    public void testGetById() {
        Patron patron = new Patron(1L, "John Doe", "john@example.com",null);

        when(patronRepository.findById(1L)).thenReturn(Optional.of(patron));

        Patron result = patronServices.getById(1L);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testAddPatron() {
        Patron patron = new Patron(1L, "John Doe", "john@example.com",null);

        assertTrue(patronServices.addPatron(patron));
        verify(patronRepository, times(1)).save(patron);
    }

    @Test
    public void testUpdatePatron() {
        Patron existingPatron = new Patron(1L, "John Doe", "john@example.com",null);
        Patron newPatron = new Patron(1L, "Jane Smith", "jane@example.com",null);

        when(patronRepository.findById(1L)).thenReturn(Optional.of(existingPatron));

        assertTrue(patronServices.updatePatron(1L, newPatron));
        verify(patronRepository, times(1)).updateById(newPatron.getName(), newPatron.getContactInformation(), 1L);
    }

    @Test
    public void testDeletePatron() {
        when(patronRepository.findById(1L)).thenReturn(Optional.of(new Patron(1L, "Jane Smith", "jane@example.com",null)));

        assertTrue(patronServices.deletePatron(1L));
        verify(patronRepository, times(1)).deleteById(1L);
    }
}
