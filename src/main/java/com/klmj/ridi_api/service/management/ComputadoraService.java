package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.pdf.ImageUtils;
import com.klmj.ridi_api.pdf.ImagesResources;
import com.klmj.ridi_api.pdf.PdfReports;
import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.repository.management.ComputadoraRepository;
import com.klmj.ridi_api.service.management.component.CPUService;
import com.klmj.ridi_api.service.management.component.DiscoDuroService;
import com.klmj.ridi_api.service.management.component.RAMService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * Esta clase representa un servicio para la gestión de entidades `Computadora`.
 * Extiende la clase `DispositivoService`, que proporciona métodos comunes para trabajar con entidades.
 */
@Service
public class ComputadoraService extends DispositivoService<Computadora> {
    public RAMService ramService;
    public CPUService cpuService;
    public DiscoDuroService discoDuroService;
    public HistorialComputadoraService historialComputadoraService;

    @Autowired
    public ComputadoraService(
            @Qualifier("computadoraRep") ComputadoraRepository repository) {
        super(repository);
    }

    @Autowired
    public void setRamService(RAMService ramService) {
        this.ramService = ramService;
    }

    @Autowired
    public void setCpuService(CPUService cpuService) {
        this.cpuService = cpuService;
    }

    @Autowired
    public void setDiscoDuroService(DiscoDuroService discoDuroService) {
        this.discoDuroService = discoDuroService;
    }

    @Autowired
    public void setHistorialComputadoraService(HistorialComputadoraService historialComputadoraService) {
        this.historialComputadoraService = historialComputadoraService;
    }

    /**
     * Guarda una computadora a la base de datos, también Guarda los componentes
     * de la computadora.
     * @param computadora el objeto a guardar.
     * @return la computadora guardada.
     */
    @Override
    public Computadora guardar(@NotNull Computadora computadora) {
        var memoriasRam = computadora.getMemoriasRam();
        var procesadores = computadora.getProcesadores();
        var discos = computadora.getDiscos();

        var computadoraGuardada = super.guardar(computadora);

        memoriasRam.forEach(m -> m.setComputadora(computadoraGuardada));
        var ramGuardadas = ramService.guardar(computadora.getMemoriasRam());
        computadoraGuardada.setMemoriasRam(ramGuardadas);

        procesadores.forEach(p -> p.setComputadora(computadoraGuardada));
        var procesadoresGuardados = cpuService.guardar(computadora.getProcesadores());
        computadoraGuardada.setProcesadores(procesadoresGuardados);

        discos.forEach(d -> d.setComputadora(computadoraGuardada));
        var discosGuardados = discoDuroService.guardar(computadora.getDiscos());
        computadoraGuardada.setDiscos(discosGuardados);

        var historial = computadora.getHistorial();
        historial.forEach(h -> h.setComputadora(computadoraGuardada));
        var historialGuardado = historialComputadoraService.guardar(historial);
        computadoraGuardada.setHistorial(historialGuardado);

        return computadoraGuardada;
    }
    /**
     * Genera un informe JasperPrint para una lista de entidades de `Computadora`.
     * @param ms La lista de entidades `Computadora` para incluir en el informe.
     * @param report La plantilla de informe PDF que se utilizará.
     * @return Un objeto JasperPrint que representa el informe.
     * @throws JRException Si hay un error al generar el informe.
     */

    @Override
    public JasperPrint generateReport(@NotNull List<Computadora> ms, @NotNull PdfReports report) throws JRException {
        Map<String, Object> params = new HashMap<>();
        InputStream logoRIDIStream = null;
        InputStream logoPieStream = null;
        try {
            logoRIDIStream = ImageUtils.openImage("pdf/images/LogoRIDI.png");
            logoPieStream= ImageUtils.openImage("pdf/images/LogoPie.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        params.put("LogoRIDI", logoRIDIStream);
        params.put("LogoPie", logoPieStream);
        params.put("ds", new JRBeanCollectionDataSource(ms));
        JRDataSource vacio = new JREmptyDataSource(1);
        /**
         * Esta madre sirve para que no
         * genere pdf vacios al final
         **/
        return JasperFillManager.fillReport(
                report.getReport(), params, vacio);
    }
}
