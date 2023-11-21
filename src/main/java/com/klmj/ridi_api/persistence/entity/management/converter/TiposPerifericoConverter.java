package com.klmj.ridi_api.persistence.entity.management.converter;

import com.klmj.ridi_api.persistence.entity.management.TiposPeriferico;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TiposPerifericoConverter implements AttributeConverter<TiposPeriferico, String> {
    @Override
    public String convertToDatabaseColumn(TiposPeriferico tipo) {
        return tipo != null ? tipo.getDescripcion() : "";
    }

    @Override
    public TiposPeriferico convertToEntityAttribute(String s) {
        for (TiposPeriferico tipo : TiposPeriferico.values()) {
            if (tipo.getDescripcion().equals(s)) return tipo;
        }
        throw new IllegalArgumentException("Descripcion no valida para TipoPeriferico: " + s);
    }
}
