package com.klmj.ridi_api.persistence.entity.management.component;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Representa un componente electrónico; es un dispositivo que forma parte de un circuito
 * electrónico.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fabricante", "modelo"})

@Entity(name = "componentes")
@Inheritance(strategy = InheritanceType.JOINED)
/**Superclase de las clases CPU, DiscoDuro y RAM**/
public class Componente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;
    @Column(name = "no_serie", nullable = false, unique = true)
    private String noSerie;
    @Column
    private String fabricante;
    @Column
    private String modelo;
}
