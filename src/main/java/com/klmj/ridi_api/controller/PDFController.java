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

    /** Metodo para generar un pdf**/
    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf() {
        try {
            //Pide una lista en este caso de computadoras a la base de datos mediante el servicio de computadora
            List<Computadora> dataSource = computadoraService.leerTodos();
            //Convierte la lista en una array de la clase JRBeanArrayDataSource
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(dataSource.toArray());
            /**Cuando se diseña el pdf con Jaspersoft Studio hay que declarar las variables
             * y campos exactamente igual
             * a como está en el codigo para que este funcione correctamente**/
            Map<String, Object> parameters = new HashMap<>();
            //LogoRIDI está declarado como una imagen de java.io.inputStream en Jaspersoft Studio
            parameters.put("LogoRIDI", ImageResources.LogoRIDI.getIcono());
            //ds fue el nombre con el que se declaró la tabla del reporte
            parameters.put("ds", ds);
            //Manda los parametros a la clase PdfService para generar el pdf
            byte[] pdfBytes = service.generarComputadoraPDF(parameters, dataSource);

            /**Una vez que regresó, esto es para cuando se abre la opcion de mostrar el pdf
             * attachment significa que es para descargarlo automaticamente y filename el nombre con el que se
             * va a guardar el reporte **/
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

        try {

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
