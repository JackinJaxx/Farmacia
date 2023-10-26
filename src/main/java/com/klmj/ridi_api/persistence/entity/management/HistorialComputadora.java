package com.klmj.ridi_api.persistence.entity.management;

import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Contiene la información historica de la computadora.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fechaRegistro", "estatus", "ipAddress", "enLinea", "locacion"})

@Entity(name = "historial_computadora")
@IdClass(HistorialComputadoraId.class)
public class HistorialComputadora {
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "serial_computadora", name = "serial_computadora")
    private Computadora computadora;
    @Id
    @Column(name = "cns", nullable = false)
    private String cns;
    @Column(name = "fecha_registro", nullable = false )
    private LocalDateTime fechaRegistro;
    @Column(name = "estatus", nullable = false)
    private String estatus;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "en_linea")
    private String enLinea;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;
}
