package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tipo_perifericos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class TipoPerifericos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo") // Especifica el nombre de la columna en la base de datos
    private long id_tipo_periferico;

    @Column(name = "nombre_tipo")
    private String nombre_tipo_periferico;


}
