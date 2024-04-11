package Library.Library.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publicationYear")
    private String publicationYear;

    @Column(name = "ISBN")
    private String ISBN;

    @OneToOne(mappedBy = "book", cascade = CascadeType.REMOVE)
    private BorrowingRecord borrowingRecords;
}
