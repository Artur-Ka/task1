package com.example.task1.service;

import com.example.task1.exception.BookAlreadyExistException;
import com.example.task1.entity.BookEntity;
import com.example.task1.exception.BookNotFoundException;
import com.example.task1.model.Book;
import com.example.task1.repository.BookRepository;
import com.example.task1.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private IRepository repository = new BookRepository();

    public List<BookEntity> getAllBooks() {
        return (List) repository.findAll();
    }

    public Book getBookById(Long id) throws BookNotFoundException {
        BookEntity book = (BookEntity) repository.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found!");
        }
        return Book.toModel(book);
    }

    public BookEntity saveBook(BookEntity book) throws BookAlreadyExistException {
        if (book.getId() == null) {
            // Не уверен в этом решении,но ночью ничего лучше не придумал
            // Смысл в том, чтобы исключить повторения книг с одинаковыми названиями и автором
            book.setId((long) (book.hashCode()));
        }
        BookEntity foundBook = (BookEntity) repository.findById(book.getId());
        if (foundBook != null && foundBook.equals(book)) {
            throw new BookAlreadyExistException("This book already exists!");
        }
        return (BookEntity) repository.save(book);
    }

    public BookEntity updateBook(Long id, BookEntity book) throws BookNotFoundException {
        BookEntity foundBook = (BookEntity) repository.findById(id);
        if (foundBook == null) {
            throw new BookNotFoundException("Book not found!");
        }
        book.setId(id);
        return (BookEntity) repository.save(book);
    }

    public Long deleteBook(Long id) {
        repository.deleteById(id);
        return id;
    }
}
