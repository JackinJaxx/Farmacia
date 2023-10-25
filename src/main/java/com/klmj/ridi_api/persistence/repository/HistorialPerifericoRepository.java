package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.HistorialComputadora;
import com.klmj.ridi_api.persistence.entity.HistorialPerifericos;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialComputadoraPrimaryKey;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialPerifericoPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HistorialPerifericoRepository  extends JpaRepository<HistorialPerifericos, HistorialPerifericoPrimaryKey> {
}

