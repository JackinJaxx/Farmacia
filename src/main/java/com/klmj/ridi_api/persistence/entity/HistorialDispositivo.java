package com.klmj.ridi_api.persistence.entity;

import com.klmj.ridi_api.persistence.entity.embedd.HistorialDispositivoPrimaryKey;
import com.klmj.ridi_api.persistence.entity.enumeration.Status;
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
 * Esta clase contiene toda la información histórica del dispositivo, donde ha estado, si puede conectarse
 * por un periférico a otros dispositivos, con cuáles, así como la dirección ip que tuvo, por último
 * contiene la fecha y hora de cuando se guarde este registro.
 */
@Entity(name = "historial_dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class HistorialDispositivo {
    @EmbeddedId
    private HistorialDispositivoPrimaryKey primaryKey;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "fecha_hora", nullable = false )
    private LocalDateTime fechaHora;
    @ManyToOne
    @JoinColumn(name = "conectado_a")
    private Dispositivo conectado;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column
    private String source;

    @OneToMany(mappedBy = "historialDispositivo")
    private List<Incidencia> incidencias;
}
