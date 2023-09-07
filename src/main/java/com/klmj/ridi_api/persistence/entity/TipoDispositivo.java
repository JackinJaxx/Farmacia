package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tipos_dispositivo")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class TipoDispositivo {
    @Id
    @Column(name = "id_tipo_dispositivo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String descripcion;
    @Column(name = "acepta_perifericos")
    private boolean aceptaPerifericos;
}
