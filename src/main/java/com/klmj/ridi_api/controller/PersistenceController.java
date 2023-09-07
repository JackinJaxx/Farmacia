package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * @param <T> la entidad
 * @param <ID> el tipo de dato de la llave primaria
 */
public abstract class PersistenceController<T, ID> {
    protected final PersistenceService<T, ID> service;

    public PersistenceController(PersistenceService<T, ID> service) {
        this.service = service;
    }

    @PostMapping("/guardar")
    public abstract ResponseEntity<T> guardar(T t);
    @GetMapping("/leer")
    public abstract ResponseEntity<T> leerPorID(ID id);
}
