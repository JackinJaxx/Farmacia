package com.klmj.ridi_api.persistence.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//https://learn.microsoft.com/es-es/windows/win32/cimwin32prov/win32-pnpentity#properties
@Getter@AllArgsConstructor@ToString
public enum Status {
    OK("ALL IT'S OK", 2),
    CONECTADO("DEVICE IS CONNECTED NOW", 2),
    DESCONECTADO("DEVICE IS DISCONNECTED NOW", 1),
    ERROR("Indica que el dispositivo tiene un error o un problema", 0),
    DEGRADED("Indica que el dispositivo no está funcionando en su nivel completo de funcionalidad o rendimiento", 1),
    STARTING("Indica que el dispositivo se está iniciando", 2),
    STOPPING("Indica que el dispositivo se está deteniendo", 2),
    SERVICE("Indica que el dispositivo es un servicio de sistema", 2),
    OTHER("Es un status desconocido por este sistema",1);

    private final String descripcion;
    private final int level;
}