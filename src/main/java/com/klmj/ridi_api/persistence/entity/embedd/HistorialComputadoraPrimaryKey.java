package com.klmj.ridi_api.persistence.entity.embedd;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HistorialComputadoraPrimaryKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_dispostivo", nullable = false)
    private Dispositivo dispositivo;
    @Column(nullable = false)
    private Integer cns;
}
