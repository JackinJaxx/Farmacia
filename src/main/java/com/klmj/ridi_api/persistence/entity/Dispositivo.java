package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Esta clase representa un artefacto que consiste en una combinación de componentes electrónicos
 * organizados en circuitos destinados a controlar y aprovechar las señales eléctricas con el propósito
 * de realizar algún proceso informático.
 *
 * Por ejemplo: una computadora, un teclado, un mouse, un altavoz, etc.
 */

@Entity(name = "dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private Long id;
    @Column(name = "nombre_dispositivo", length = 35, nullable = false)
    private String descripcion;
    @Column(length = 35)
    private String fabricante;
    @OneToMany(mappedBy = "historialDispositivo")
    private List<Incidencia> incidencias;

}
