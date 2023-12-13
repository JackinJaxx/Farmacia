package com.klmj.ridi_api.controller.management;

import com.klmj.ridi_api.controller.PdfController;
import com.klmj.ridi_api.controller.PersistenceController;
import com.klmj.ridi_api.pdf.ImageUtils;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import com.klmj.ridi_api.service.management.HistorialComputadoraService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

import static com.klmj.ridi_api.controller.PdfController.createHeader;
/**Controlador REST para las operaciones relacionadas con el historial de computadoras,
 * hereda de PersistenceController para operaciones básicas
 * y PdfController para la exportación de archivos PDF**/

@RestController
@RequestMapping("/dispositivos/computadoras/historial")
public class HistorialComputadoraController
        extends PersistenceController<HistorialComputadora, HistorialComputadoraId> {
    protected HistorialComputadoraService service;

    public HistorialComputadoraController(HistorialComputadoraService service) {
        super(service);
        this.service = service;
    }

    @Override
    @PostMapping("/por-historial")
    public ResponseEntity<HistorialComputadora> guardar(HistorialComputadora historialComputadora) {
        System.out.println("GUARDANDO POR HISTORIAL");
        return super.guardar(historialComputadora);
    }

    @GetMapping("/{serial}")
    public ResponseEntity<List<HistorialComputadora>> leerPorComputadora(@PathVariable("serial") long serialComputadora) {
        return new ResponseEntity<>(service.leerPorComputadora(serialComputadora), HttpStatus.FOUND);
    }


    /** Método para exportar un informe PDF del historial de computadoras mediante una solicitud GET**/

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() {
        InputStream logoRIDIStream = getClass().getResourceAsStream("pdf/images/LogoRIDI.png");
        ImageUtils.closeImage(logoRIDIStream);
        InputStream logoPieStream = getClass().getResourceAsStream("pdf/images/LogoPie.png");
        ImageUtils.closeImage(logoPieStream);

        try {
            return ResponseEntity.ok()
                    .headers(createHeader("ReporteHistorialComputadoras", "reporte-historial-computadoras"))
                    .body(service.exportPdf(service.leerTodos(), PdfReports.HISTORIAL));
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
