package com.klmj.ridi_api.persistence.entity.management;

import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Contiene la información historica del periferico.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fechaRegistro", "estatus", "locacion", "conectadoA"})

@Entity(name = "historial_perifericos")
@IdClass(HistorialPerifericoId.class)
public class HistorialPeriferico {
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "serial_periferico", name = "serial_periferico")
    private Periferico periferico;
    @Id
    @Column(name = "cns", nullable = false)
    private String cns;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
    @Column(name = "estatus", nullable = false)
    private String estatus;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;
    /**
     * Es la computadora a la que está conectada.
     */
    @ManyToOne
    @JoinColumn(name = "conectado_a")
    private Computadora conectadoA;
}
