package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.service.PdfService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
/** Clase abstracta que sirve como controlador base para la exportación de archivos PDF**/

public abstract class PdfController <T, ID> extends PersistenceController<T, ID> {
    /** Servicio utilizado para la generación de archivos PDF**/
    protected PdfService<T, ID> service;

    public PdfController(PdfService<T, ID> service) {
        super(service);
        this.service = service;
    }

    /** Método estático para crear encabezados para la respuesta HTTP al exportar un PDF**/

    public static @NotNull HttpHeaders createHeader(String name, String pdfName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline()
                .name(name)
                .filename(pdfName + "%s.pdf"
                        .formatted(LocalDate.now()))
                .build());
        return headers;
    }

    /** Método abstracto que debe ser implementado por las clases que heredan esta clase**/

    @GetMapping("/pdf")
    public abstract ResponseEntity<byte[]> exportPdf();
}
