package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "disco_duro")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DiscoDuro {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "no_serie")
    private Componente componente;

    @Column(name = "almacenamiento")
    private String almacenamiento;

    @Column(name = "nombre_disco")
    private String nombreDisco;
}
