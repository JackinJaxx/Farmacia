package com.klmj.ridi_api.persistence.entity.embedd;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
public class HistorialPerifericoPrimaryKey implements Serializable {
    @JoinColumn(name = "id_periferico")
    private Long idPeriferico;

    @Column(name = "cns")
    private String cns;

}
