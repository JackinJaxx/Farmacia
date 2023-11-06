package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.klmj.ridi_api.persistence.entity.management.component.CPU;
import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "computadoras")
@PrimaryKeyJoinColumn(name = "serial_computadora")
public class Computadora extends Dispositivo implements Serializable {
    @Column(name = "sistema_operativo", length = 100, nullable = false)
    private String sistemaOperativo;
    @Column(name = "nombre_sistema", length = 30, nullable = false)
    private String nombreSistema;
    @Column(length = 50, nullable = false)
    private String modelo;
    @Column(name = "ip_address")
    private String ipAddress;

    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<RAM> memoriasRam;
    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<CPU> procesadores;
    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<DiscoDuro> discos;

    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<HistorialComputadora> historial;



}
