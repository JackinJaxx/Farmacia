package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.pdf.ImagesResources;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialComputadoraId;
import com.klmj.ridi_api.persistence.repository.management.HistorialComputadoraRepository;
import com.klmj.ridi_api.service.PdfService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class HistorialComputadoraService extends
        PdfService<HistorialComputadora, HistorialComputadoraId> {

    protected HistorialComputadoraRepository repository;

    @Autowired
    public HistorialComputadoraService(
            HistorialComputadoraRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /*@Autowired
    public void setComputadoraService(ComputadoraService computadoraService) {
        this.computadoraService = computadoraService;
    }*/

    @Override
    public HistorialComputadora guardar(@NotNull HistorialComputadora historialComputadora) {
        var computadora = historialComputadora.getComputadora();
        if (Objects.isNull(computadora)) return null;

        historialComputadora.setCns(repository.countByComputadora_Serial(computadora.getSerial()) + 1);
        return repository.save(historialComputadora);
    }

    /**
     * Regresa todo el historial de una computadora.
     * @param serialComputadora es la id de computadora.
     * @return una lista con todos los historiales.
     */
    public List<HistorialComputadora> leerPorComputadora(long serialComputadora) {
        return repository.findByComputadora_Serial(serialComputadora);
    }

    @Override
    public JasperPrint generateReport(@NotNull List<HistorialComputadora> ms, @NotNull PdfReports report) throws JRException {
        Map<String, Object> params = new HashMap<>();

        params.put("ds", new JRBeanCollectionDataSource(ms));
        params.put("LogoRIDI", ImagesResources.LOGO_RIDI.getIcono());
        params.put("LogoRIDI_F", ImagesResources.LogoRIDI_F.getIcono());

        JRDataSource vacio = new JREmptyDataSource(2);
        /**
         * Esta madre sirve para que no
         * genere pdf vacios al final
        **/
        return JasperFillManager.fillReport(
                report.getReport(), params, vacio);
    }
}
