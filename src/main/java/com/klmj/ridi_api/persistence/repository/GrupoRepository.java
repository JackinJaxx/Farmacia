package com.klmj.ridi_api.persistence.repository;

import com.klmj.ridi_api.persistence.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Enum> {
}
