package com.klmj.ridi_api.persistence.entity;

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

@Entity(name = "estados")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Estado {
    @Id
    @Column(name = "id_estado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 20, unique = true)
    private String nombre;
}
