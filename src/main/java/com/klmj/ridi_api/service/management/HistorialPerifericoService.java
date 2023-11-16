package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.pdf.ImagesResources;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import com.klmj.ridi_api.persistence.repository.management.HistorialComputadoraRepository;
import com.klmj.ridi_api.persistence.repository.management.HistorialPerifericoRepository;
import com.klmj.ridi_api.service.PdfReportService;
import com.klmj.ridi_api.service.PersistenceService;
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
public class HistorialPerifericoService extends
        PersistenceService<HistorialPeriferico, HistorialPerifericoId> implements PdfReportService<HistorialPeriferico> {
    protected HistorialPerifericoRepository repository;
    @Autowired
    public HistorialPerifericoService(HistorialPerifericoRepository repository){super(repository);
        this.repository = repository;
    }

    @Override
    public byte[] exportPdf(@NotNull List<HistorialPeriferico> data, @NotNull PdfReports report) throws JRException {
        return JasperExportManager.exportReportToPdf(generateReport(data, report));
    }

    @Override
    public JasperPrint generateReport(@NotNull List<HistorialPeriferico> ms, @NotNull PdfReports report) throws JRException {
        Map<String, Object> params = new HashMap<>();

        params.put("ds", new JRBeanCollectionDataSource(ms));
        params.put("LogoRIDI", ImagesResources.LOGO_RIDI.getIcono());

        return JasperFillManager.fillReport(
                report.getReport(), params, new JRBeanCollectionDataSource(ms));
    }
}
