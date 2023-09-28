package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.HistorialDispositivo;
import com.klmj.ridi_api.persistence.entity.embedd.HistorialDispositivoPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialDispositivoRepository extends JpaRepository<HistorialDispositivo, HistorialDispositivoPrimaryKey> {
}
