package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.service.PdfService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

public abstract class PdfController <T, ID> extends PersistenceController<T, ID> {
    protected PdfService<T, ID> service;

    public PdfController(PdfService<T, ID> service) {
        super(service);
        this.service = service;
    }

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

    @GetMapping("/pdf")
    public abstract ResponseEntity<byte[]> exportPdf();
}
