package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.klmj.ridi_api.persistence.entity.management.converter.TiposPerifericoConverter;
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
public class Periferico extends Dispositivo {
    @Column(nullable = false)
    private String tipo;
    private String descripcion;
    private String nombre;
    @JsonManagedReference
    @OneToMany(mappedBy = "periferico")
    private List<HistorialPeriferico> historial;
}