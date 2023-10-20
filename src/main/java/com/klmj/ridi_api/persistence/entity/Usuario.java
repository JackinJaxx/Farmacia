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
    @Column(name = "id_usuario", nullable = false)
    private String id_usuario;
    @Column(name = "correo_electronico", nullable = false)
    private String correo_electronico;
    @Column(name = "no telefono", nullable = false)
    private String no_telefono;
    @Column(name = "nombre_usuario", nullable = false)
    private String nombre;
    @Column(name = "apellido_p", nullable = false)
    private String apellido_p;
    @Column(name = "apellido_m", nullable = false)
    private String apellido_m;
    @Column(name = "passwd", nullable = false)
    private String password;
    @ManyToMany(mappedBy = "encargados", fetch = FetchType.LAZY)
    private Set<Incidencia> incidencias = new HashSet<>();
}