package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * Clase que se encarga de generar el pdf.
 * El metodo recibe de parametros un Map de String y Object,
 * y una lista de Computadora desde la clase PDFController
 * que regresa **/
@Service
public class PdfService {

    protected JasperReport report;

    @Autowired
    public void setReport(JasperReport report) {
        this.report = report;
    }

    public byte[] generarComputadoraPDF(Map<String, Object> parameters, List<Computadora> computadoras) throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(computadoras));
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
