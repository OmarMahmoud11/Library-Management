package Library.Library.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "borrowingId", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patronId", nullable = false)
    @JsonIgnore
    private Patron patron;

    @OneToOne
    @JoinColumn(name = "bookId", nullable = false)
    @JsonIgnore
    private Book book;

    @Column(name = "returnDate", nullable = false)
    private Date returnDate;
}
