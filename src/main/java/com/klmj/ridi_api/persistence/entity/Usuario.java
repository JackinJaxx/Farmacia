package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 */
@Entity(name = "usuarios")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @Column(name = "nombre_usuario", nullable = false)
    private String nombre;
    @Column(name = "passwd", nullable = false)
    private String password;
    @ManyToMany(mappedBy = "encargados", fetch = FetchType.LAZY)
    private Set<Incidencia> incidencias = new HashSet<>();
}