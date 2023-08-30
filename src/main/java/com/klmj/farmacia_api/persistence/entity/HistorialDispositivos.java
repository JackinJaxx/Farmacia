package com.klmj.farmacia_api.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;

@Entity(name = "historial_dispositivos")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class HistorialDispositivos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historial;
    @ManyToOne @JoinColumn(name = "id_dispositivo", nullable = false)
    private Dispositivos dispositivo;
    @ManyToOne @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursales sucursal;
    @ManyToOne @JoinColumn(name = "id_status", nullable = false)
    private Status status;
    @Column(nullable = false )
    private LocalDateTime fecha_hora;
    @Column(length = 15)
    private String ip_dispositivo;
    @ManyToOne @JoinColumn(name = "conectado_a", nullable = false)
    private Dispositivos conectado;

}
