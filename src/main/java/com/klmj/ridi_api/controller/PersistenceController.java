package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Un controlador con los métodos CRUD básicos implementados para cada clase controlador
 * @param <T> instancia de la @Entity class.
 * @param <ID> el tipo de dato de la @Id class.
 */
public abstract class PersistenceController<T, ID> {
    protected final PersistenceService<T, ID> service;
    protected final Logger logger;

    public PersistenceController(PersistenceService<T, ID> service) {
        this.service = service;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @PostMapping
    public ResponseEntity<T> guardar(@RequestBody T t) {
        logger.info("Petición Post a las %s".formatted(LocalDateTime.now()));

        T entitySaved = service.guardar(t);

        if (Objects.isNull(entitySaved))
            return new ResponseEntity<>(t, HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(entitySaved, HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<List<T>> guardar(@RequestBody List<T> ts) {
        logger.info("Petición Post a las %s".formatted(LocalDateTime.now()));

        List<T> entitiesSaved = service.guardar(ts);

        if (Objects.isNull(entitiesSaved))
            return new ResponseEntity<>(ts, HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(entitiesSaved, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> leerPorID(@PathVariable("id") ID id) {
        logger.info("Petición Get a las %s".formatted(LocalDateTime.now()));

        Optional<T> entityRead = service.leerPorID(id);

        return entityRead
                .map(e -> new ResponseEntity<>(e, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<T>> leerTodos() {
        //logger.info("Petición Get a las %s".formatted(LocalDateTime.now()));

        return new ResponseEntity<>(service.leerTodos(), HttpStatus.FOUND);
    }

    @PutMapping
    public Boolean actualizar(@RequestBody T t) {
        logger.info("Petición Put a las %s".formatted(LocalDateTime.now()));

        return service.actualizar(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable("id") ID id) {
        logger.info("Petición Delete a las %s".formatted(LocalDateTime.now()));

        boolean result = service.borrar(id);

        if (result)
            return new ResponseEntity<>("instancia borrada correctamente", HttpStatus.FOUND);
        return new ResponseEntity<>(
                "no hay instancia que coincidan con el id %s"
                        .formatted(id), HttpStatus.NOT_MODIFIED);
    }
}
