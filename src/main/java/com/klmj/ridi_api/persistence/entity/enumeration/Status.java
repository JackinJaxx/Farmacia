package com.klmj.ridi_api.persistence.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter@AllArgsConstructor@ToString
public enum Status {
    OK("ALL IT'S OK", 2),
    CONECTADO("DEVICE IS CONNECTED NOW", 2),
    DESCONECTADO("DEVICE IS DISCONNECTED NOW", 1),
    DESCOMPUESTO("DEVICE IS BROKEN NOW", 0);

    private final String descripcion;
    private final int level;
}