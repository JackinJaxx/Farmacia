package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoPeriferico tipoPerifericos;

    @JsonManagedReference
    @OneToMany(mappedBy = "periferico")
    private List<HistorialPeriferico> historialPeriferico;



}
