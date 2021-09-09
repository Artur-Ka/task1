package com.example.task1.repository;

import com.example.task1.entity.Entity;

public interface IRepository<T extends Entity> {
    T save(T t);

    T findById(Long id);

    Iterable<T> findAll();

    void deleteById(Long id);
}
