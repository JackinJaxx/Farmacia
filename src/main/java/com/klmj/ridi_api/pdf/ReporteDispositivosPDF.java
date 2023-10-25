package com.klmj.ridi_api.pdf;

import com.klmj.ridi_api.persistence.entity.Dispositivo;
import com.lowagie.text.pdf.PdfPTable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.util.List;
import java.util.Map;

@Component("")
public class ReporteDispositivosPDF extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Dispositivo> dispositivoList = (List<Dispositivo>) model.get("dispositivos");
        int columnas = 1;
        PdfPTable tablaReportes = new PdfPTable(columnas);

       // dispositivoList.forEach(dispositivo -> {
          //  tablaReportes.addCell(dispositivo.getId());
            
       // });
    }
}
