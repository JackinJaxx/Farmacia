package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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