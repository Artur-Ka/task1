package com.example.task1.model;

import com.example.task1.entity.BookEntity;

public class Book {
    private Long id;
    private String name;
    private String author;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static Book toModel(BookEntity entity) {
        Book book = new Book();
        book.setId(entity.getId());
        book.setName(entity.getName());
        book.setAuthor(entity.getAuthor());
        return book;
    }
}
