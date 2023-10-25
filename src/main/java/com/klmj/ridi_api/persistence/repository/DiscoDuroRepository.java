package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.Componente;
import com.klmj.ridi_api.persistence.entity.DiscoDuro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscoDuroRepository extends JpaRepository<DiscoDuro, Componente> {
}
