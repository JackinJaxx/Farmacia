package com.klmj.ridi_api.persistence.entity.management;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public enum TiposPeriferico {
    USB("USB"),
    AUDIO_ENDPOINT("Audio Endpoint"),
    KEYBOARD("Keyboard"),
    MOUSE("Mouse"),
    DISPLAY("Display"),
    BLUETOOTH("Bluetooth"),
    CAMERA("Camera"),
    HID("HID");

    private final String descripcion;

    TiposPeriferico(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonCreator
    public static @NotNull TiposPeriferico fromDescripcion(String descripcion) {
        for (TiposPeriferico tipo : TiposPeriferico.values()) {
            if (tipo.descripcion.equalsIgnoreCase(descripcion)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("No se encontró un tipo para la descripción: " + descripcion);
    }

    @JsonValue
    public String toJson() {
        return this.descripcion;
    }
}
