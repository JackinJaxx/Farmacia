package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tipo_dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class TipoDispositivos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipo_dispositivo;
    @Column(length = 50)
    private String descripcion_dispositivo;
}
