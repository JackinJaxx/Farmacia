package com.klmj.ridi_api.persistence.entity.management;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "perifericos")
@PrimaryKeyJoinColumn(name = "serial_periferico")
public class Periferico extends Dispositivo{
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoPeriferico tipoPerifericos;

    @OneToMany(mappedBy = "periferico")
    private List<HistorialPeriferico> historialPeriferico;
}
