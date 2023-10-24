package com.klmj.ridi_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "componentes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Componente {
    @Id
    @Column(name = "no_serie", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String noSerieComponente;

    @Column(name = "fabricante")
    private String fabricanteComponente;

    @Column(name = "modelo")
    private String modeloComponente;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_dispositivo")
    private Computadora computadora;

}
