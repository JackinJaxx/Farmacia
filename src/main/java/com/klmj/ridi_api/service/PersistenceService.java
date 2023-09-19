package com.klmj.ridi_api.service;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * @param <T> la entidad
 * @param <ID> el tipo de dato de la llave primaria
 */

public abstract class PersistenceService <T, ID> {

    protected final JpaRepository<T, ID> repository;

    public PersistenceService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    /*public abstract T guardar(@RequestBody T t);
    public abstract Optional<T> leerPorID(@PathVariable ID id);
    public abstract List<T> leer(@PathVariable T t);
    public abstract List<T> leerTodos();
    public abstract boolean borrar(@PathVariable ID id);*/


    /**
     * Guarda y actualiza la entidad T
     * @param t el objeto a guardar
     * @return el nuevo objeto, si se está creando con una nueva id, retorna el objeto con la id
     * generada
     */
    public T guardar(T t) {
        return repository.save(t);
    }
    public Optional<T> leerPorID(ID id) {
        return repository.findById(id);
    }
    public List<T> leer(T t) {
        return repository.findAll(Example.of(t));
    }
    public List<T> leerTodos() {
        return repository.findAll();
    }
    public boolean borrar(ID id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }
}
