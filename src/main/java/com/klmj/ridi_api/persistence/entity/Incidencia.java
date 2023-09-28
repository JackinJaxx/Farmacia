package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 */
@Entity(name = "incidencias")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Incidencia {
    @Id
    @Column(name = "id_incidencia", nullable = false)
    private Integer id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "encargados_incidencia",
            joinColumns = @JoinColumn(name = "incidencia"),
            inverseJoinColumns = @JoinColumn(name = "encargado")
    )
    private Set<Usuario> encargados = new HashSet<>();
    @Column
    private String descripcion;
    @Column(name = "fecha_solucion")
    private LocalDateTime fechaSolucion;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_dispositivo", referencedColumnName = "id_dispositivo"),
            @JoinColumn(name = "cns", referencedColumnName = "cns")
    })
    private HistorialDispositivo historialDispositivo;
}
