package Library.Library.Services;

import Library.Library.Entities.Patron;
import Library.Library.Repositories.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class PatronServices {
    @Autowired
    private PatronRepository repo;

    public List<Patron> retrieveAll(){
        return repo.findAll();
    }
    public Patron getById(Long id){
        return repo.findById(id).orElse(null);
    }
    public boolean addPatron(Patron patron){
        if(patron == null)return false;
        repo.save(patron);
        return true;
    }
    public boolean updatePatron(Long id,Patron newPatron){
        if(!repo.findById(id).isPresent())return false;
        repo.updateById(newPatron.getName(),newPatron.getContactInformation(),id);
        return true;
    }
    public boolean deletePatron(Long id){
        if(!repo.findById(id).isPresent())return false;
        repo.deleteById(id);
        return true;
    }
}
