package com.klmj.ridi_api.persistence.entity;

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
@Entity(name = "historial_dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class HistorialDispositivo {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_dispositivo", nullable = false)
    private Dispositivo dispositivo;
    @Id
    private int cns;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;
    @Column(nullable = false )
    private LocalDateTime fecha_hora;
    @ManyToOne
    @JoinColumn(name = "conectado_a", nullable = false)
    private Dispositivo conectado;
    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

}
