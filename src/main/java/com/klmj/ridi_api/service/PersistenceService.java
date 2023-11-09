package com.klmj.ridi_api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
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
 * Un servicio con los métodos CRUD básicos implementados.
 * @param <T> instancia de la @Entity class.
 * @param <ID> el tipo de dato de la @Id class.
 */
@Getter
public abstract class PersistenceService <T,ID> {

    protected final JpaRepository<T, ID> repository;

    public PersistenceService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    /**
     * Guarda un objeto en la base de datos si no existe
     * @param t el objeto a guardar.
     * @return un nuevo objeto de la misma instancia de la tabla, incluyendo una id en caso de
     * generarse automáticamente.
     */
    public T guardar(@NotNull T t) {
        //if (repository.exists(Example.of(t))) return null;
        return repository.save(t);
    }

    public List<T> guardar(@NotNull List<T> ts) {
        return ts.stream().map(this::guardar).toList();
    }

    /**
     * Busca en la base de datos un objeto que coincida con una id.
     * @param id el valor de la id a filtrar.
     * @return Optional con la instancia que se encontró.
     */
    public Optional<T> leerPorID(@NotNull ID id) {
        return repository.findById(id);
    }

    /**
     * Obtiene todas las instancias que se encuentren en la base de datos.
     * @return un List, estará vacío en caso de no encontrar nada.
     */
    public List<T> leerTodos() {
        return repository.findAll();
    }

    /**
     * Actualiza una instancia en la base de datos en caso de estar ya guardada.
     * @param t el objeto a actualizar.
     * @return verdadero en caso de no haber ningún problema, al contrario devuelve falso.
     */
    public boolean actualizar(@NotNull T t) {
        if (repository.exists(Example.of(t))) return false;
        repository.save(t);
        return true;
    }

    /**
     * Borra una instancia en la base de datos filtrando por una id.
     * @param id la id a filtrar.
     * @return verdadero en caso de no haber ningún problema, al contrario devuelve falso.
     */
    public boolean borrar(@NotNull ID id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }

    public boolean siExiste(@NotNull T t) {
        try {
            return repository.exists(Example.of(t));
        } catch (EntityNotFoundException ex) {
            System.out.printf("%n**%s no encontrado**%n%n", t);
            return false;
        }
    }


}
