package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Dispositivos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dispositivo;
    @Column(length = 50, nullable = false)
    private String tipo;
    @Column(length = 100, nullable = false)
    private String nombre;
}
