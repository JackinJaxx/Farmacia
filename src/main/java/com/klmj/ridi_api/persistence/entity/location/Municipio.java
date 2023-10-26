package com.klmj.ridi_api.persistence.entity.location;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"nombre", "estado"})

@Entity(name = "municipios")
public class Municipio {
    @Id
    @Column(nullable = false, name = "id_municipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 50)
    private String nombre;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_estado")
    private Estado estado;
}
