package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.pdf.ImagesResources;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.HistorialPeriferico;
import com.klmj.ridi_api.persistence.entity.management.embedd.HistorialPerifericoId;
import com.klmj.ridi_api.persistence.repository.management.HistorialPerifericoRepository;
import com.klmj.ridi_api.service.PdfService;
import com.klmj.ridi_api.service.PersistenceService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class HistorialPerifericoService extends
        PdfService<HistorialPeriferico, HistorialPerifericoId> {
    protected HistorialPerifericoRepository repository;

    @Autowired
    public HistorialPerifericoService(HistorialPerifericoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public HistorialPeriferico guardar(@NotNull HistorialPeriferico historialPeriferico) {
        var periferico = historialPeriferico.getPeriferico();
        if (Objects.isNull(periferico)) return null;

        historialPeriferico.setCns(repository.countByPeriferico_Serial(periferico.getSerial()) + 1);
        return repository.save(historialPeriferico);
    }

    /**
     * Regresa todo el historial de un periferico.
     * @param serialPeriferico es la id de periferico.
     * @return una lista con todos los historiales.
     */
    public List<HistorialPeriferico> leerPorPeriferico(long serialPeriferico) {
        return repository.findByPeriferico_Serial(serialPeriferico);
    }

    @Override
    public JasperPrint generateReport(@NotNull List<HistorialPeriferico> ms, @NotNull PdfReports report) throws JRException {
        Map<String, Object> params = new HashMap<>();

        params.put("LogoRIDI", ImagesResources.LOGO_RIDI.getIcono());
        params.put("ds", new JRBeanCollectionDataSource(ms));

        return JasperFillManager.fillReport(
                report.getReport(), params, new JRBeanCollectionDataSource(ms));
    }
}
