package com.klmj.ridi_api.persistence.entity.management.embedd;

import com.klmj.ridi_api.persistence.entity.management.Periferico;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Embeddable
//Clase que sirve para generar la llave primaria compuesta por el Id de la clase TipoPeriferico
// y el cns que se genera automaticamente
public class HistorialPerifericoId implements Serializable {
    @ManyToOne
    @JoinColumn(referencedColumnName = "serial_periferico", name = "serial_periferico")
    private Periferico periferico;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String cns;
}
