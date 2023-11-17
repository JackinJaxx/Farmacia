package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.persistence.entity.Usuario;
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
 * Un controlador con los métodos CRUD básicos implementados.
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json", value = "/auth")
    public ResponseEntity<Usuario> autenticar(@RequestBody T t) {
        logger.info("Petición Post a las %s".formatted(LocalDateTime.now()));

        if (!service.siExiste(t)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<T> entityRead = service.buscarPor(t);
        entityRead.ifPresent(e -> logger.info("Usuario autenticado: %s".formatted(e)));

        Usuario usuario = (Usuario) entityRead.get();
        usuario.setPassword(null);
        usuario.setSalt(null);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json")
    public ResponseEntity<T> guardar(@RequestBody T t) {
        logger.info("Petición Post a las %s".formatted(LocalDateTime.now()));

        T entitySaved = service.guardar(t);

        if (Objects.isNull(entitySaved))
            return new ResponseEntity<>(t, HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(entitySaved, HttpStatus.OK);
    }

    @PostMapping(value = "/todo", produces = "application/json")
    public ResponseEntity<List<T>> guardar(@RequestBody List<T> ts) {
        logger.info("Petición Post a las %s".formatted(LocalDateTime.now()));

        List<T> entitiesSaved = service.guardar(ts);

        if (Objects.isNull(entitiesSaved))
            return new ResponseEntity<>(ts, HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(entitiesSaved, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<T> leerPorID(@PathVariable("id") ID id) {
        logger.info("Petición Get a las %s".formatted(LocalDateTime.now()));

        Optional<T> entityRead = service.leerPorID(id);

        return entityRead
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<T>> leerTodos() {
        //logger.info("Petición Get a las %s".formatted(LocalDateTime.now()));

        return new ResponseEntity<>(service.leerTodos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(produces = "application/json")
    public Boolean actualizar(@RequestBody T t) {
        logger.info("Petición Put a las %s".formatted(LocalDateTime.now()));

        return service.actualizar(t);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> borrar(@PathVariable("id") ID id) {
        logger.info("Petición Delete a las %s".formatted(LocalDateTime.now()));

        boolean result = service.borrar(id);

        if (result)
            return new ResponseEntity<>("instancia borrada correctamente", HttpStatus.OK);
        return new ResponseEntity<>(
                "no hay instancia que coincidan con el id %s"
                        .formatted(id), HttpStatus.NOT_MODIFIED);
    }
}
