package org.example.lib.service.BookService;

import org.example.lib.dao.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBooks();
    Book saveBook(Book book);
    Book findBookById(Long id);
}
