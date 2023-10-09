package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<T> guardar(@RequestBody T t) {
        T entitySaved = service.guardar(t);

        return new ResponseEntity<>(entitySaved, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> leerPorID(@PathVariable("id") ID id) {
        Optional<T> entityRead = service.leerPorID(id);

        return entityRead
                .map(e -> new ResponseEntity<>(e, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    /*
    @GetMapping("/leer/{entity}")
    public ResponseEntity<List<T>> leer(@PathVariable("entity") T t) {
        List<T> entitiesRead = service.leer(t);
        return new ResponseEntity<>(entitiesRead, HttpStatus.OK);
    }*/

    @GetMapping
    public ResponseEntity<List<T>> leerTodos() {
        return new ResponseEntity<>(service.leerTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable("id") ID id) {
        boolean result = service.borrar(id);
        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
    }
}
