package com.klmj.ridi_api.persistence.entity;

import com.klmj.ridi_api.persistence.entity.management.Dispositivo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Representa un seguimiento a un historial de un dispositivo, por ejemplo; cuando ocurre algún
 * problema que requiera una supervisión de un usuario, aquí se mantiene el control de la
 * incidencia.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fechaInicio", "fechaSolucion", "descripcion", "estatus", "dispositivo", "encargados"})

@Entity(name = "incidencias")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia", nullable = false)
    private Long id;
    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;
    @Column(name = "fecha_solucion")
    private LocalDateTime fechaSolucion;
    @Column
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private EstatusIncidencia estatus;

    @ManyToOne
    @JoinColumn(name = "serial_dispositivo")
    private Dispositivo dispositivo;

    @ManyToMany
    @JoinTable(
            name = "encargados_incidencia",
            joinColumns = @JoinColumn(
                    name = "incidencia",
                    referencedColumnName = "id_incidencia"),
            inverseJoinColumns = @JoinColumn(
                    name = "encargado",
                    referencedColumnName = "id_usuario"))
    private List<Usuario> encargados;
}
