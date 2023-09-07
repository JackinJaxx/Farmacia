package com.klmj.ridi_api.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class PersistenceController<T, ID> {
    protected final JpaRepository<T, ID> repository;

    public PersistenceController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @PostMapping("/guardar")
    public abstract ResponseEntity<T> guardar(@RequestBody T t);
    @GetMapping("/leer")
    public abstract ResponseEntity<T> leerPorID(@PathVariable ID id);
}
