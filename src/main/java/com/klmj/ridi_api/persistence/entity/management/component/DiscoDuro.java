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
 * Representa un dispositivo de almacenamiento de datos.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "discos_duros")
@PrimaryKeyJoinColumn(referencedColumnName = "serial", name = "serial_disco_duro")
public class DiscoDuro extends Componente{
    /**
     * En GigaBytes
     */
    @Column(name = "almacenamiento")
    private String almacenamiento;
    @Column(name = "nombre_disco")
    private String nombreDisco;

    @ManyToOne
    @JoinColumn(name = "serial_computadora")
    private Computadora computadora;
}
