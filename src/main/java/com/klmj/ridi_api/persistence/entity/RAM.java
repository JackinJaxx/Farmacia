package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ram")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RAM {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "no_serie")
    private Componente componente;

    @Column(name = "capacidad")
    private String capacidad;
}
