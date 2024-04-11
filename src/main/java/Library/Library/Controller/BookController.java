package Library.Library.Controller;

import Library.Library.Entities.Book;
import Library.Library.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookServices service;

    @GetMapping
    public List<Book> retrieveAll(){
        return service.retrieveAll();
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable long id){
        return service.getById(id);
    }
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        if(service.addBook(book))
            return new ResponseEntity<>("Add Book success", HttpStatus.OK);
        return new ResponseEntity<>("Add Book has Failed",HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable long id,@RequestBody Book newBook){
        if(service.updateBook(id,newBook))
            return new ResponseEntity<>("Update Book success", HttpStatus.OK);
        return new ResponseEntity<>("Update Book has Failed",HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id){
        if(service.deleteBook(id))
            return new ResponseEntity<>("Delete Book success", HttpStatus.OK);
        return new ResponseEntity<>("Delete Book has Failed",HttpStatus.NOT_ACCEPTABLE);
    }
}
