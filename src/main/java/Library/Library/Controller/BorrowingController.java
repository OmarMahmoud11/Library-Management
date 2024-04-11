package Library.Library.Controller;

import Library.Library.Services.BorrowingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BorrowingController {
    @Autowired
    private BorrowingServices service;
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String> borrowBook(@PathVariable Long bookId,@PathVariable Long patronId){
        service.addRecord(bookId,patronId);
        return new ResponseEntity<>("Book borrowed successfully", HttpStatus.OK);
    }
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId,@PathVariable Long patronId){
        service.returnBook(bookId,patronId);
        return new ResponseEntity<>("Book returned successfully", HttpStatus.OK);
    }
}
