package com.klmj.ridi_api.pdf;

import lombok.Getter;

import java.io.InputStream;
import java.util.Objects;

/**
 *Clase donde se declaran las direcciones de las imagenes a usar
 */

@Getter
public enum ImagesResources {
    COMPUTADORA_BIEN(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/computadoraBien.png"))),
    COMPUTADORA_MAL(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/computadoraMal.png"))),
    LOGO_RIDI(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/LogoRIDI.png"))),
    DISCO_DURO(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/discoDuro.png"))),
    CPU(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/CPU.png"))),
    RAM(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/RAM.png"))),
    LogoRIDI_F(Objects.requireNonNull(
            ImagesResources.class.getClassLoader().getResourceAsStream(
                    "pdf/images/LogoRIDI_F.png")));

    private final InputStream icono;

    ImagesResources(InputStream inputStream){
        icono = inputStream;
    }
}
