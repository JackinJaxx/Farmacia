package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PdfController;
import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.service.management.ComputadoraService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispositivos/computadoras")
public class ComputadoraController extends
        PdfController<Computadora, Long> {
    @Autowired
    public ComputadoraController(ComputadoraService service) {
        super(service);
    }

    @Override
    public ResponseEntity<byte[]> exportPdf() {
        try {
            return ResponseEntity.ok()
                    .headers(createHeader("ReporteComputadoras", "reporte-computadoras"))
                    .body(service.exportPdf(service.leerTodos(), PdfReports.COMPUTADORAS));
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
