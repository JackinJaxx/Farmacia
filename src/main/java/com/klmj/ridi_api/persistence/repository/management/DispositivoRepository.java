package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository <D extends Dispositivo> extends JpaRepository<D, Long> {
    D findByNoSerie(String noSerie);
}
