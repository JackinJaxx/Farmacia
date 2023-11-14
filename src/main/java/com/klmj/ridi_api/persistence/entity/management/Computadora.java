package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.klmj.ridi_api.persistence.entity.management.component.CPU;
import com.klmj.ridi_api.persistence.entity.management.component.DiscoDuro;
import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

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
    private List<RAM> memoriasRam = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<CPU> procesadores = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<DiscoDuro> discos = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "computadora")
    private List<HistorialComputadora> historial = new ArrayList<>();

    @JsonIgnore
    @Transient
    private String estatusActual;
    @JsonIgnore
    @Transient
    private String locacionActual;

    /** El método generate está anotado con @PostLoad porque genera la propiedad estatusActual
     * basada en la propiedad histórica de la entidad.
     * Esto asegura que la propiedad estatusActual esté siempre actualizada,
     * incluso si la propiedad historial se modifica después
     * de que la entidad haya sido cargada desde la base de datos.
     */

    @PostLoad
    public void generate() {
        if (historial.isEmpty()) {
            estatusActual = "NO REGISTRADO";
            locacionActual = "NO REGISTRADO";
            return;
        }

        var lastHistorial = historial.get(historial.size() - 1);

        estatusActual = lastHistorial.getEstatus();
        locacionActual = lastHistorial.getLocacion().getNombre();
    }

    public void setHistorial(List<HistorialComputadora> historial) {
        this.historial = historial;
        generate();
    }
}
