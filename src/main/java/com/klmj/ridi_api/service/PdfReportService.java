package com.klmj.ridi_api.service;

import com.klmj.ridi_api.pdf.PdfReports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.List;

public interface PdfReportService <T>{
    byte[] exportPdf(List<T> data, PdfReports report) throws JRException;
    JasperPrint generateReport(List<T> data, PdfReports report) throws JRException;

}
