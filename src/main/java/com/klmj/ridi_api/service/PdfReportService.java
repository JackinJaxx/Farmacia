package com.klmj.ridi_api.service;

import com.klmj.ridi_api.pdf.PdfReports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.List;
/**
 * Esta interfaz representa un servicio para generar informes PDF a partir de una lista de entidades.
 * @param <T> El tipo de entidad que se va a informar.
 */
public interface PdfReportService <T>{
    /**
     * Exporta una lista de entidades a un informe PDF.
     * @param data La lista de entidades que se va a informar.
     * @param report La plantilla de informe PDF a utilizar.
     * @return Un array de bytes que contiene los datos del informe PDF.
     * @throws JRException Si se produce un error al generar el informe.
     */
    byte[] exportPdf(List<T> data, PdfReports report) throws JRException;
    /**
     * Genera un `JasperPrint` a partir de una lista de entidades y una plantilla de informe PDF.
     * @param data La lista de entidades que se va a informar.
     * @param report La plantilla de informe PDF a utilizar.
     * @return Un objeto `JasperPrint` que representa el informe.
     * @throws JRException Si se produce un error al generar el informe.
     */
    JasperPrint generateReport(List<T> data, PdfReports report) throws JRException;

}
