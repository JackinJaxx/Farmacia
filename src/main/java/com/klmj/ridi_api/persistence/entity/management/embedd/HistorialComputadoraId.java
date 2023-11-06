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
public class HistorialComputadoraId implements Serializable{
    @ManyToOne
    @JoinColumn(referencedColumnName = "serial_computadora", name = "serial_computadora")
    private Computadora computadora;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer cns;
}