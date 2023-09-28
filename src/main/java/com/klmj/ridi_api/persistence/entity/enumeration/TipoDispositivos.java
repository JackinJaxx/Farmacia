package com.klmj.ridi_api.persistence.entity.enumeration;

import lombok.*;

@Getter @AllArgsConstructor@ToString
public enum TipoDispositivos {
    PC(true),
    PHONE(true),
    PRINTER(true),
    HEADSET(false),
    MOUSE(false),
    USB_DRIVER(false),
    DISK(false),
    CONTROLLER(false),
    KEYBOARD(false),
    OTHER(false);

    private final boolean acepta_perifericos;
}