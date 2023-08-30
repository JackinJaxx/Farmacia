package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "estados")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Estados {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;
    @Column(nullable = false , length = 20, unique = true)
    private String nombre_estado;

}
