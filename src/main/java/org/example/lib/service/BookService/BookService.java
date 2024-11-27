package org.example.lib.service.BookService;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Book;
import org.example.lib.dao.repository.BookRepository;
import org.example.lib.service.BookService.i.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
    }

}
