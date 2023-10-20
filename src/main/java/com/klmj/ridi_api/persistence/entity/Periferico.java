package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "perifericos")
@Getter
@Setter
public class Periferico {
    @Id
    private long id_periferico;
    @OneToOne
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoPerifericos tipoPerifericos;
}
