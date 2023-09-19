package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * @param <T> es la entidad de persistencia a la que haremos referencia
 * @param <ID> el tipo de dato de su llave primaria
 */
public abstract class PersistenceController<T, ID> {
    protected final PersistenceService<T, ID> service;
    protected final Logger logger;

    public PersistenceController(PersistenceService<T, ID> service) {
        this.service = service;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @PostMapping
    public abstract ResponseEntity<T> guardar(@RequestBody T t);
    @GetMapping
    public abstract ResponseEntity<T> leerPorID(ID id);
    @PostMapping
    public abstract ResponseEntity<List<T>> leer(T t);
    @GetMapping
    public abstract ResponseEntity<List<T>> leerTodos();
    @DeleteMapping
    public abstract ResponseEntity<HttpStatus> borrar(ID id);
}
