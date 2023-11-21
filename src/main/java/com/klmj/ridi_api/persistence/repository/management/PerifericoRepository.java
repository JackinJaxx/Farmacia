package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.Periferico;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Qualifier("perifericoRep")
@Repository
public interface PerifericoRepository extends DispositivoRepository<Periferico> {
    Periferico findByNoSerie(String noSerie);
}
