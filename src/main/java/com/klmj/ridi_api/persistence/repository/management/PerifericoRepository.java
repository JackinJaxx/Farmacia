package com.klmj.ridi_api.persistence.repository.management;

import com.klmj.ridi_api.persistence.entity.management.Periferico;
import com.klmj.ridi_api.persistence.entity.management.TipoPeriferico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerifericoRepository extends JpaRepository<Periferico, Long> {
}
