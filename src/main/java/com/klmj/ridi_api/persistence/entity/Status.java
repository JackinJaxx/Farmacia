package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "status")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;

    @Column(name = "descripcion_status")
    private String descripcionStatus;

}
