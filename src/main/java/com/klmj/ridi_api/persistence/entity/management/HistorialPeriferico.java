package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.klmj.ridi_api.persistence.entity.location.Locacion;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;

/**
 * @author Kevin Alejandro Francisco Gonzalez
 * @author Jose Alejandro Perez Chavez
 * @author Mauricio Betancourt Mora
 * @author Luis Hurtado Gomez
 * @version 1.0
 * Contiene la información historica del periferico.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"fechaRegistro", "estatus", "locacion", "conectadoA"})

@Entity(name = "historial_periferico")
@IdClass(HistorialPerifericoId.class)
public class HistorialPeriferico {
    @JsonBackReference
    @Id
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "serial_periferico",
            name = "serial_periferico",
            nullable = false)
    private Periferico periferico;
    @Id
    @Min(value = 1, message = "El consecutivo debe ser mayor a 0")
    @Column(name = "cns", nullable = false)
    private Integer cns;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
    @Column(name = "estatus")
    private String estatus;
    @ManyToOne
    @JoinColumn(name = "id_locacion")
    private Locacion locacion;
    /**
     * Es la computadora a la que está conectada.
     */
    @ManyToOne
    @JoinColumn(name = "conectado_a")
    private Computadora conectadoA;


    @JsonIgnore
    @Transient
    private String direccionComputadora;

    @JsonIgnore
    @Transient
    private String conectedTo;

    @JsonIgnore
    @Transient
    private String tipoPeriferico;

    @JsonIgnore
    @Transient
    private String noSeriePeriferico;

    @JsonIgnore
    @Transient
    private String fechaConFormato;

    @PostLoad
    public void generate() {
        if(conectadoA.getNoSerie() == null){
            conectedTo = "Ahorita no hay";
        }else {
            conectedTo = conectadoA.getNoSerie();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        direccionComputadora = locacion.getDireccion();
        tipoPeriferico = periferico.getTipoPerifericos().getDescripcion();
        noSeriePeriferico = periferico.getNoSerie();
        fechaConFormato = fechaRegistro.format(formatter);
    }
}
