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

/**
 * Esta clase abstracta representa un servicio para generar informes PDF a partir de una lista de entidades.
 * Extiende la clase `PersistenceService`, que proporciona métodos comunes para trabajar con entidades.
 *
 * @param <T> El tipo de entidad que se va a informar.
 * @param <ID> El tipo del identificador de la entidad.
 */
public abstract class PdfService<T, ID> extends PersistenceService<T, ID> implements PdfReportService<T> {
    /**
     * Crea una nueva instancia de la clase `PdfService`.
     * @param repository El repositorio para el tipo de entidad.
     */
    public PdfService(
            JpaRepository<T, ID> repository) {
        super(repository);
    }
    /**Exporta una lista de entidades a un informe PDF.
     * @param data La lista de entidades que se va a informar.
     * @param report La plantilla de informe PDF a utilizar.
     * @return Un array de bytes que contiene los datos del informe PDF.
     * @throws JRException Si se produce un error al generar el informe.
     */
    @Override
    public byte[] exportPdf(List<T> data, PdfReports report) throws JRException {
        return JasperExportManager.exportReportToPdf(generateReport(data, report));
    }

/**Genera un `JasperPrint` a partir de una lista de entidades y una plantilla de informe PDF.
 * @param ms La lista de entidades que se va a informar.
 * @param report La plantilla de informe PDF a utilizar.
 * @return Un objeto `JasperPrint` que representa el informe.
    **/
    public abstract JasperPrint generateReport(@NotNull List<T> ms, @NotNull PdfReports report) throws JRException;

}