package Library.Library.Services;

import Library.Library.Entities.Book;
import Library.Library.Repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BookServices {
    @Autowired
    BookRepository repo;

    public List<Book> retrieveAll(){
        return repo.findAll();
    }
    public Book getById(Long id){
        return repo.findById(id).orElse(null);
    }
    public boolean addBook(Book book){
        if(book == null) return false;
        repo.save(book);
        return true;
    }
    public boolean updateBook(Long id,Book newBook){
        if(!repo.findById(id).isPresent())return false;
        repo.updateById(newBook.getTitle(),newBook.getAuthor(),newBook.getPublicationYear(),newBook.getISBN(),id);
        return true;
    }
    public boolean deleteBook(Long id){
        if(!repo.findById(id).isPresent())return false;
        repo.deleteById(id);
        return true;
    }
}
