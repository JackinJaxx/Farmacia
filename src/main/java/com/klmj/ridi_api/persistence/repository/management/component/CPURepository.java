package com.klmj.ridi_api.persistence.repository.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.CPU;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Qualifier("cpuRep")
@Repository
public interface CPURepository extends ComponenteRepository<CPU> {
}
