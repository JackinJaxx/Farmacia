package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "municipios")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Municipios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_municipio;
    @Column(nullable = false , length = 50)
    private String nombre_municipio;
    @ManyToOne @JoinColumn(nullable = false, name = "id_estado")
    private Estados id_estado;
}
