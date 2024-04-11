package Library.Library.Controller;

import Library.Library.Entities.Patron;
import Library.Library.Services.PatronServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
@CrossOrigin
public class PatronController {
    @Autowired
    private PatronServices service;
    @GetMapping
    public List<Patron> retrieveAll(){
        return service.retrieveAll();
    }
    @GetMapping("/{id}")
    public Patron getById(@PathVariable long id){
        return service.getById(id);
    }
    @PostMapping
    public ResponseEntity<String> addPatron(@RequestBody Patron patron){
        if(service.addPatron(patron))
            return new ResponseEntity<>("Add Patron success", HttpStatus.OK);
        return new ResponseEntity<>("Add Patron has Failed",HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatron(@PathVariable long id,@RequestBody Patron newPatron){
        if(service.updatePatron(id,newPatron))
            return new ResponseEntity<>("Update Patron success", HttpStatus.OK);
        return new ResponseEntity<>("Update Patron has Failed",HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable long id){
        if(service.deletePatron(id))
            return new ResponseEntity<>("Delete Patron success", HttpStatus.OK);
        return new ResponseEntity<>("Delete Patron has Failed",HttpStatus.NOT_ACCEPTABLE);
    }
}
