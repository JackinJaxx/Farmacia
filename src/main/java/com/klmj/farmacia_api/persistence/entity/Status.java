package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "status")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Status {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status;
    @Column(length = 10, nullable = false)
    private String descripcion_status;
}
