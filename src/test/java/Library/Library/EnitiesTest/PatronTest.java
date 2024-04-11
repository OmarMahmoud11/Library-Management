package Library.Library.EnitiesTest;
import Library.Library.Entities.Patron;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatronTest {
    @Test
    public void classTest(){
        Patron patron = new Patron(1L,"name","contact",null);
        Assertions.assertThat(patron.getName()).isEqualTo("name");
        Assertions.assertThat(patron.getId()).isEqualTo(1);
        Assertions.assertThat(patron.getContactInformation()).isEqualTo("contact");
        patron.setName("name2");
        patron.setContactInformation("contact2");
        patron.setId(5L);
    }
}
