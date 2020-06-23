package com.codegym.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    Page<T> findAll(Pageable pageable);
    T findById(Long id);
    void save(T model);
    void remove(Long id);
}
