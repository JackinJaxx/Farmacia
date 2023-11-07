package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.Computadora;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Qualifier("computadoraRep")
@Repository
public interface ComputadoraRepository extends DispositivoRepository<Computadora> {
}
