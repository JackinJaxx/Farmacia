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
 * Representa una unidad central de procesamiento (CPU) o procesador; es un componente del hardware
 * dentro de un ordenador, teléfonos inteligentes, y otros dispositivos programables.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "cpus")
@PrimaryKeyJoinColumn(referencedColumnName = "serial", name = "serial_cpu")
public class CPU extends Componente{
    @Column(name = "nucleos_logicos")
    private String nucleosLogicos;
    @Column(name = "nucleos_fisicos")
    private String nucleosFisicos;
    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "serial_computadora")
    private Computadora computadora;
}
