package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "sucursales")
@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class Sucursales {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sucursal;
    @Column(nullable = false , length = 50, unique = true)
    private String nombre_sucursal;
    @Column(nullable = false , length = 50)
    private String direccion_sucursal;
    @ManyToOne @JoinColumn(name = "id_municipio", nullable = false)
    private Municipios id_municipio;
}
