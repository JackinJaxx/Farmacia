package com.klmj.ridi_api.service;

import com.klmj.ridi_api.pdf.ImagesResources;
import com.klmj.ridi_api.pdf.PdfReports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PdfService<T, ID> extends PersistenceService<T, ID> {

    public PdfService(
            JpaRepository<T, ID> repository) {
        super(repository);
    }

    public byte[] exportPdf(@NotNull List<T> ms, @NotNull PdfReports report) throws JRException {
        return JasperExportManager.exportReportToPdf(generateReport(ms, report));
    }

    public abstract JasperPrint generateReport(@NotNull List<T> ms, @NotNull PdfReports report) throws JRException;

}