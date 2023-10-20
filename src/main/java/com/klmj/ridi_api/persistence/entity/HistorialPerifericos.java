package com.klmj.ridi_api.persistence.entity;

import com.klmj.ridi_api.persistence.entity.embedd.HistorialDispositivoPrimaryKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "historial_perifericos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HistorialPerifericos {
    @EmbeddedId
    private HistorialDispositivoPrimaryKey primaryKey;
}
