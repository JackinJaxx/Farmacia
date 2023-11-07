package com.klmj.ridi_api.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.service.PdfService;
import com.klmj.ridi_api.service.management.ComputadoraService;
import com.klmj.ridi_api.util.ImageResources;
import com.klmj.ridi_api.util.PDFJasper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PDFController {

    private PdfService service;
    private ComputadoraService computadoraService;

    @Autowired
    public void setComputadoraService(
            PdfService service,
            ComputadoraService computadoraService) {
        this.computadoraService = computadoraService;
        this.service = service;
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf() {
        try {
            List<Computadora> dataSource = computadoraService.leerTodos();
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(dataSource.toArray());
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("LogoRIDI", ImageResources.LogoRIDI.getIcono());
            parameters.put("ds", ds);

            byte[] pdfBytes = service.generarComputadoraPDF(parameters, dataSource);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=report.pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } catch (JRException e) {
            // Manejar errores aquí
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/exportarPDFComputadoras")
    public ModelAndView exportarPDFComputadoras(@RequestParam("lista") String jsonComputadoras) {
        ModelAndView modelAndView = new ModelAndView();
       // modelAndView.setView(new JasperReportsPdfView()); // Usa la vista de JasperReportsPdfView

        try {
            // Resto del código para cargar datos y plantillas de JasperReports
            // ...
            InputStream LogoRIDI = ImageResources.LogoRIDI.getIcono(),
                    computadoraBien = ImageResources.COMPUTADORA_BIEN.getIcono(),
                    computadoraMal = ImageResources.COMPUTADORA_MAL.getIcono(),
                    reporteComputadora = PDFJasper.ReporteRIDI.getIcono();
            Gson gson = new Gson();
            List<Computadora> reporteComputadoras = computadoraService.leerTodos();
            List<Computadora> reporteComputadoras2 = new ArrayList<>();
            reporteComputadoras.add(new Computadora());
            reporteComputadoras2.add(gson.fromJson(jsonComputadoras, new TypeToken<List<Computadora>>(){}.getType()));
            reporteComputadoras.addAll(reporteComputadoras2);
            JasperReport report = (JasperReport) JRLoader.loadObject(reporteComputadora);
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteComputadoras.toArray());

            // Configura los parámetros y origen de datos
            modelAndView.addObject("ds", ds);
            modelAndView.addObject("LogoRIDI", LogoRIDI);
            modelAndView.addObject("reporte", reporteComputadora);

            return modelAndView;
        } catch (Exception e) {
            // Manejo de errores
            return new ModelAndView("errorView", "error", "Error: " + e.getMessage());
        }
    }
}
