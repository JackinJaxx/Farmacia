package com.klmj.ridi_api.controller;

import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.Incidencia;
import com.klmj.ridi_api.service.IncidenciaService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @CrossOrigin(origins = "http://localhost:4200")
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
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(produces = "application/json")
    @Override
    public Boolean actualizar(@RequestBody Incidencia incidencia) {
        logger.info("Petición Put a las %s".formatted(LocalDateTime.now()));
        logger.info("Incidencia a actualizar: %s".formatted(incidencia));
        Incidencia incidenciaActual = service.leerPorID(incidencia.getId()).orElse(null);

        if (incidenciaActual == null) return false;

        BeanUtils.copyProperties(incidencia, incidenciaActual, "id","dispositivo", "encargados");
        return service.guardar(incidenciaActual) != null;
    }
}
