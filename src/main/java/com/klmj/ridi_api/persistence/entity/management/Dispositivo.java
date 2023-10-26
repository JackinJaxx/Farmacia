package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.klmj.ridi_api.persistence.entity.Incidencia;
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
 * Por ejemplo: una computadora, un teclado, un mouse, un altavoz, etc.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fabricante"})

@Entity(name = "dispositivos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial")
    private Long serial;
    @Column(name = "no_serie", nullable = false, unique = true)
    private String noSerie;
    @Column(length = 35)
    private String fabricante;
}
