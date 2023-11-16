package com.klmj.ridi_api.service;

import com.klmj.ridi_api.pdf.ImagesResources;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.Incidencia;
import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.repository.IncidenciaRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IncidenciaService extends PersistenceService<Incidencia, Long> implements PdfReportService<Incidencia>{
    @Autowired
    public IncidenciaService(IncidenciaRepository repository) {
        super(repository);
    }

    @Override
    public byte[] exportPdf(@NotNull List<Incidencia> data, @NotNull PdfReports report) throws JRException {
        return JasperExportManager.exportReportToPdf(generateReport(data, report));
    }

    @Override
    public JasperPrint generateReport(@NotNull List<Incidencia> ms, @NotNull PdfReports report) throws JRException {
        Map<String, Object> params = new HashMap<>();

        params.put("ds", new JRBeanCollectionDataSource(ms));
        params.put("LogoRIDI", ImagesResources.LOGO_RIDI.getIcono());

        return JasperFillManager.fillReport(
                report.getReport(), params, new JRBeanCollectionDataSource(ms));
    }
}
