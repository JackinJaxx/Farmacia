package com.klmj.ridi_api.persistence.entity;

import com.klmj.ridi_api.persistence.entity.embedd.HistorialComputadoraPrimaryKey;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Esta clase contiene toda la información histórica del dispositivo, donde ha estado, si puede conectarse
 * por un periférico a otros dispositivos, con cuáles, así como la dirección ip que tuvo, por último
 * contiene la fecha y hora de cuando se guarde este registro.
 */
@Entity(name = "historial_computadora")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class HistorialComputadora {
    @EmbeddedId
    private HistorialComputadoraPrimaryKey primaryKey;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;
    @Column(name = "fecha_hora", nullable = false )
    private LocalDateTime fechaHora;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "en_linea")
    private String enLinea;

}
