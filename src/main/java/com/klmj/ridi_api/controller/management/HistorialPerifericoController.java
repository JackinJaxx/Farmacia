package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import com.klmj.ridi_api.service.management.HistorialPerifericoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.klmj.ridi_api.controller.PdfController.createHeader;

@RestController
@RequestMapping("/dispositivos/perifericos/historial")
public class HistorialPerifericoController extends PersistenceController<HistorialPeriferico, HistorialPerifericoId> {

    protected HistorialPerifericoService service;

    @Autowired
    public HistorialPerifericoController(HistorialPerifericoService service){
        super(service);
        this.service = service;
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() {
        try {
            return ResponseEntity.ok()
                    .headers(createHeader("ReporteHistorialPeriferico", "reporte-historial-periferico"))
                    .body(service.exportPdf(service.leerTodos(), PdfReports.HISTORIAL_PERIFERICOS));
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
