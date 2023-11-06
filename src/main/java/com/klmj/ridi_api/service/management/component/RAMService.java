package com.klmj.ridi_api.service.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import com.klmj.ridi_api.persistence.repository.management.component.RAMRepository;
import com.klmj.ridi_api.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RAMService extends PersistenceService<RAM, Long> {
    @Autowired
    public RAMService(RAMRepository repository) {
        super(repository);
    }
}
