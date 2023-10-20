package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "computadoras")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Computadora {
    @Id
    private long id_computadora;
    @Column(name = "sistema_operativo", length = 20)
    private String sistemaOperativo;
    @OneToOne
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;
}
