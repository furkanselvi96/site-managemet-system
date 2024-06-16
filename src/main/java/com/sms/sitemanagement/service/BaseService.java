package com.sms.sitemanagement.service;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public abstract class BaseService<T, ID> {


    private JpaRepository<T, ID> repository;

    public T save(T entity) {
        return repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public long count() {
        return repository.count();
    }
}
