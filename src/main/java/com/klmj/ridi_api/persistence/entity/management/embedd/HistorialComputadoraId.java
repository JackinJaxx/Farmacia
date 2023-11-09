package com.klmj.ridi_api.persistence.entity.management.embedd;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
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
//Clase que sirve para generar la llave primaria compuesta por el Id de Computadora y el cns que se genera automaticamente
public class HistorialComputadoraId implements Serializable{
    @ManyToOne
    @JoinColumn(referencedColumnName = "serial_computadora", name = "serial_computadora")
    private Computadora computadora;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer cns;
}