package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.klmj.ridi_api.persistence.entity.management.component.CPU;
import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "historial")
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "computadoras")
@PrimaryKeyJoinColumn(name = "serial_computadora")
public class Computadora extends Dispositivo {
    @Column(name = "sistema_operativo", length = 20)
    private String sistemaOperativo;
    @Column(name = "nombre_sistema", length = 30)
    private String nombreSistema;
    @Column(length = 50)
    private String modelo;
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(mappedBy = "computadora")
    private List<RAM> memoriasRam;
    @OneToMany(mappedBy = "computadora")
    private List<CPU> procesadores;
    @OneToMany(mappedBy = "computadora")
    private List<DiscoDuro> discos;

    @JsonIgnore
    @OneToMany(mappedBy = "computadora")
    private List<HistorialComputadora> historial;
}
