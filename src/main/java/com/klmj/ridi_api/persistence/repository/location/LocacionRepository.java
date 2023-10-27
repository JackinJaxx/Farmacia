package com.klmj.ridi_api.persistence.repository.location;

import com.klmj.ridi_api.persistence.entity.location.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LocacionRepository extends JpaRepository<Locacion, Long> {
}
