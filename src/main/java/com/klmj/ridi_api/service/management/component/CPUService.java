package com.klmj.ridi_api.service.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.CPU;
import com.klmj.ridi_api.persistence.repository.management.component.CPURepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPUService extends PersistenceService<CPU, Long> {
    @Autowired
    public CPUService(CPURepository repository) {
        super(repository);
    }
}
