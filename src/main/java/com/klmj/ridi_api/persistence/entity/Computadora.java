package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "computadoras")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Computadora extends Dispositivo{
    @Id
    @OneToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "id_dispositivo")
    private Dispositivo dispositivo;

    @Column(name = "sistema_operativo", length = 20)
    private String sistemaOperativo;

    @Column(name = "ram", length = 20)
    private String ram;

    @Column(name = "cpu", length = 20)
    private String cpu;

    @Column(name = "disco_duro", length = 20)
    private String discoDuro;

    @OneToMany(mappedBy = "historialComputadora")
    private List<Incidencia> incidencias;

}
