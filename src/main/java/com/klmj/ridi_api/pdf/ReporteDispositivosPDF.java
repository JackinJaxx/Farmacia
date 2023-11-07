package com.klmj.ridi_api.pdf;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.entity.management.Dispositivo;
import com.klmj.ridi_api.service.management.ComputadoraService;
import com.klmj.ridi_api.util.ImageResources;
import com.klmj.ridi_api.util.PDFJasper;
import com.lowagie.text.pdf.PdfPTable;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("")
@Service("dispositivos/computadoras/pdf")
public class ReporteDispositivosPDF extends HttpServlet {
    private ComputadoraService computadoraService;

    @Autowired
    public void setComputadoraService(ComputadoraService computadoraService) {
        this.computadoraService = computadoraService;
    }

    @GetMapping
    private void exportarPDFComputadoras(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        ServletOutputStream out = response.getOutputStream();
        try {
            InputStream LogoRIDI = ImageResources.LogoRIDI.getIcono(),
            computadoraBien = ImageResources.COMPUTADORA_BIEN.getIcono(),
            computadoraMal = ImageResources.COMPUTADORA_MAL.getIcono(),
            reporteComputadora = PDFJasper.ReporteRIDI.getIcono();

            if(LogoRIDI != null && computadoraBien != null && computadoraMal != null && reporteComputadora != null){
                String jsonComputadoras = request.getParameter("lista");
                Gson gson = new Gson();
                List<Computadora> reporteComputadoras = computadoraService.leerTodos();
                List<Computadora> reporteComputadoras2 = new ArrayList<>();
                reporteComputadoras.add(new Computadora());
                reporteComputadoras2.add(gson.fromJson(jsonComputadoras, new TypeToken<List<Computadora>>(){}.getType()));
                reporteComputadoras.addAll(reporteComputadoras2);
                JasperReport report = (JasperReport) JRLoader.loadObject(reporteComputadora);
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteComputadoras.toArray());
                Map<String, Object> parameters =  new HashMap<>();
                parameters.put("ds", ds);
                parameters.put("LogoRIDI", LogoRIDI);
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "attachment ; filename = ReporteComputadoras.pdf");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
                out.close();
            } else {
                response.setContentType("text/plain");
                out.println("No se pudo generar el pdf");
                out.println("Contacte a soporte, pelmazo");
            }

        }
        catch (Exception e){
            response.setContentType("text/plain");
            out.print("Error: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
