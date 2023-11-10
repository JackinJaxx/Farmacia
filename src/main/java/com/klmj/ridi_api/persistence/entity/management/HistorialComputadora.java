package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Contiene la información historica de la computadora.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fechaRegistro", "estatus", "ipAddress", "enLinea", "locacion"})

@Entity(name = "historial_computadora")
@Table
@IdClass(HistorialComputadoraId.class)
public class HistorialComputadora implements Serializable {
    @JsonBackReference
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "serial_computadora", name = "serial_computadora", nullable = false)
    private Computadora computadora;
    @Id
    @Min(value = 1, message = "El consecutivo debe de ser mayor a 0")
    @Column(name = "cns", nullable = false)
    private Integer cns;
    @Column(name = "fecha_registro", nullable = false )
    private LocalDateTime fechaRegistro;
    @Transient
    private String fechaConFormato;
    @Column(name = "estatus")
    private String estatus;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "en_linea", nullable = false)
    private boolean enLinea = true;
    @ManyToOne
    @JoinColumn(name = "id_locacion", nullable = false)
    private Locacion locacion;

    public void setFechaConFormato(String fechaConFormato) {
        this.fechaConFormato = fechaConFormato;
        this.fechaRegistro = LocalDateTime.parse(fechaConFormato, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public String getNoSerieComputadora() {
        return computadora.getNoSerie();
    }

    public String getNombreComputadora() {
        return computadora.getNombreSistema();
    }
}
