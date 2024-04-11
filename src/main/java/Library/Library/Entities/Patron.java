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
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactInformation")
    private String contactInformation;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.REMOVE)
    private List<BorrowingRecord> borrowingRecords;
}
