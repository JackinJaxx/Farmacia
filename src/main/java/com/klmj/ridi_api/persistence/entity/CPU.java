package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cpu")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CPU {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "no_serie")
    private Componente componente;

    @Column(name = "nucleos_logicos")
    private String nucleosLogicos;

    @Column(name = "nucleos_fisicos")
    private String nucleosFisicos;
}
