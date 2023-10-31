package com.klmj.ridi_api.persistence.repository.location;

import com.klmj.ridi_api.persistence.entity.location.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocacionRepository extends JpaRepository<Locacion, Long> {
    /**
     * Filtra por estado las locaciones.
     * @param idEstado id del estado.
     * @return una lista de locaciones.
     */
    @Query("SELECT l FROM locaciones l " +
            "WHERE l.municipio.estado.clave = :id")
    List<Locacion> findByEstado(@Param("id") long idEstado);

    /**
     * Filtra por municipio las locaciones.
     * @param idMunicipio id del municipio.
     * @return una lista de locaciones.
     */
    @Query("SELECT l FROM locaciones l " +
            "WHERE l.municipio.id = :id")
    List<Locacion> findByMunicipio(@Param("id") long idMunicipio);
}
