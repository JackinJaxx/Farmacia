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
 * Representa la memoria principal de un dispositivo, donde se almacenan de forma temporal los
 * datos de los programas que estás utilizando en este momento.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "rams")
@PrimaryKeyJoinColumn(referencedColumnName = "serial", name = "serial_ram")
public class RAM extends Componente{
    /**
     * En GigaBytes
     */
    @Column
    private String capacidad;

    @ManyToOne
    @JoinColumn(name = "serial_computadora")
    private Computadora computadora;
}
