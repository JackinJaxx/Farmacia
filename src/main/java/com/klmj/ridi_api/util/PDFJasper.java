package com.klmj.ridi_api.util;

import lombok.Getter;

import java.io.InputStream;
import java.util.Objects;

@Getter
public enum PDFJasper {
    ReporteRIDI(Objects.requireNonNull(ImageResources.class.getClassLoader().getResourceAsStream("jasper/ReporteRIDI.jasper")));
    private final InputStream icono;
    PDFJasper(InputStream url){
        icono = url;
    }
}

