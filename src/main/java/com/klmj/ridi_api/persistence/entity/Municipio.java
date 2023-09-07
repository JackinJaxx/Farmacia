package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "municipios")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Municipio {
    @Id
    @Column(name = "id_municipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 50)
    private String nombre;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_estado")
    private Estado estado;
}
