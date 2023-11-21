package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.Periferico;
import com.klmj.ridi_api.persistence.repository.management.PerifericoRepository;
import com.klmj.ridi_api.service.PersistenceService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerifericoService extends DispositivoService<Periferico> {
    protected HistorialPerifericoService historialPerifericoService;

    @Autowired
    public PerifericoService(PerifericoRepository repository) {
        super(repository);
    }

    @Autowired
    public void setHistorialPerifericoService(HistorialPerifericoService historialPerifericoService) {
        this.historialPerifericoService = historialPerifericoService;
    }

    @Override
    public Periferico guardar(@NotNull Periferico periferico) {
        var perifericoGuardado = super.guardar(periferico);

        var historial = periferico.getHistorial();
        historial.forEach(h -> h.setPeriferico(perifericoGuardado));

        var historialGuardado = historialPerifericoService.guardar(historial);
        if (historialGuardado != null)
            perifericoGuardado.setHistorial(historialGuardado);

        return perifericoGuardado;
    }

    @Override
    public JasperPrint generateReport(@NotNull List<Periferico> ms, @NotNull PdfReports report) throws JRException {
        return null;
    }
}
