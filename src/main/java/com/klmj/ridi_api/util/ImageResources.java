package com.klmj.ridi_api.util;

import com.lowagie.text.pdf.codec.Base64;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;

import javax.swing.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

@Getter
public enum ImageResources {
    COMPUTADORA_BIEN(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("img/computadoraBien.png"))),
    COMPUTADORA_MAL(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("img/computadoraMal.png"))),
    LogoRIDI(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("img/LogoRIDI.png"))),
    discoDuro(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("img/discoDuro.png"))),
    CPU(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("img/CPU.png"))),
    RAM(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("img/RAM.png")));
    private final InputStream icono;

    ImageResources(InputStream url){
        icono = url;
    }

}
