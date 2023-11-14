package com.klmj.ridi_api.pdf;

import lombok.Getter;
import net.sf.jasperreports.engine.*;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;

/**Clase donde se declaran las url de los reportes para generarlos **/
@Getter
public enum PdfReports {
    COMPUTADORAS(Objects.requireNonNull(PdfReports.class.getClassLoader().getResource("pdf/ReporteComputadoras.jrxml"))),
    HISTORIAL(Objects.requireNonNull(PdfReports.class.getClassLoader().getResource("pdf/ReporteHistorial.jrxml")));


    private final JasperReport report;

    PdfReports(URL url) {
        try {
            this.report = JasperCompileManager.compileReport(ResourceUtils.getFile(url)
                    .getAbsolutePath());
        } catch (JRException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
