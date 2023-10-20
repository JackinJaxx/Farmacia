package com.klmj.ridi_api.persistence.entity.embedd;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Setter @Getter
public class HistorialDispositivoPrimaryKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_computadora", nullable = false)
    private Dispositivo dispositivo;
    @Column(nullable = false)
    private Integer cns;

    @Override
    public String toString() {
        return "pk: %s de %s".formatted(dispositivo.getId(), cns);
    }
}
