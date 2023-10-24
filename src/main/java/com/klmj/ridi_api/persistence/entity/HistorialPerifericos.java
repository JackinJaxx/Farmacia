package com.klmj.ridi_api.persistence.entity;

import com.klmj.ridi_api.persistence.entity.embedd.HistorialPerifericoPrimaryKey;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "historial_perifericos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HistorialPerifericos {
    @EmbeddedId
    private HistorialPerifericoPrimaryKey perifericoPrimaryKey;
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;
    @ManyToOne
    @JoinColumn(name = "conectado_a")
    private Dispositivo conectado;

}
