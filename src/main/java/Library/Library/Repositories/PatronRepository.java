package Library.Library.Repositories;

import Library.Library.Entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron,Long> {
    @Modifying
    @Query("""
            UPDATE Patron p
            SET p.name = (?1), p.contactInformation = (?2)
            WHERE p.id = (?3)""")
    void updateById(String name,String contactInformation,Long id);
}
