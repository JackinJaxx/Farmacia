package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.Incidencia;
import com.klmj.ridi_api.service.IncidenciaService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.klmj.ridi_api.controller.PdfController.createHeader;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController extends PersistenceController<Incidencia, Long> {

    protected IncidenciaService service;
    @Autowired
    public IncidenciaController(IncidenciaService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() {
        try {
            return ResponseEntity.ok()
                    .headers(createHeader("ReporteIncidencias", "reporte-incidencias"))
                    .body(service.exportPdf(service.leerTodos(), PdfReports.INCIDENCIAS));
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
