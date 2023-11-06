package com.klmj.ridi_api.service.management;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import com.klmj.ridi_api.persistence.repository.management.ComputadoraRepository;
import com.klmj.ridi_api.service.PersistenceService;
import com.klmj.ridi_api.service.management.component.CPUService;
import com.klmj.ridi_api.service.management.component.DiscoDuroService;
import com.klmj.ridi_api.service.management.component.RAMService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputadoraService extends PersistenceService<Computadora, Long> {
    public RAMService ramService;
    public CPUService cpuService;
    public DiscoDuroService discoDuroService;
    public HistorialComputadoraService historialComputadoraService;

    @Autowired
    public ComputadoraService(
            ComputadoraRepository repository) {
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

        var nComputadora = super.guardar(computadora);

        memoriasRam.forEach(m -> m.setComputadora(nComputadora));
        var nMemoriasRam = ramService.guardar(computadora.getMemoriasRam());
        nComputadora.setMemoriasRam(nMemoriasRam);

        procesadores.forEach(p -> p.setComputadora(nComputadora));
        var nProcesadores = cpuService.guardar(computadora.getProcesadores());
        nComputadora.setProcesadores(nProcesadores);

        discos.forEach(d -> d.setComputadora(nComputadora));
        var nDiscos = discoDuroService.guardar(computadora.getDiscos());
        nComputadora.setDiscos(nDiscos);

        //var historial = computadora.getHistorial();
        //historial.forEach(h -> h.setComputadora(nComputadora));
        //var nHistorial = historialComputadoraService.guardar(historial);
        //nComputadora.setHistorial(nHistorial);

        return nComputadora;
    }
}
