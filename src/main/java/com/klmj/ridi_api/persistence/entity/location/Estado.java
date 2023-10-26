package com.klmj.ridi_api.persistence.entity.location;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Esta clase representa un estado real en el mundo; un espacio que posee lo siguiente: una población
 * permanente, un territorio definido y un gobierno que es capaz de mantener control efectivo sobre el
 * territorio correspondiente y de conducir relaciones internacionales con otros estados.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "nombre")

@Entity(name = "estados")
public class Estado {
    @Id
    @Column(name = "clave_estado", nullable = false, length = 3)
    private String clave;
    @Column(nullable = false , length = 20, unique = true)
    private String nombre;
}
