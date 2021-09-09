package com.example.task1.repository;

import com.example.task1.entity.BookEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Имитация CrudRepository
 */
public class BookRepository implements IRepository<BookEntity> {
    private final Map<Long, BookEntity> books = new HashMap<>();

    @Override
    public BookEntity save(BookEntity bookEntity) {
        return books.put(bookEntity.getId(), bookEntity);
    }

    @Override
    public BookEntity findById(Long id) {
        return books.get(id);
    }

    @Override
    public Iterable<BookEntity> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void deleteById(Long id) {
        books.remove(id);
    }
}
