package com.klmj.ridi_api.service.management.component;

import com.klmj.ridi_api.persistence.entity.management.component.RAM;
import com.klmj.ridi_api.persistence.repository.management.component.RAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RAMService extends ComponentService<RAM> {
    @Autowired
    public RAMService(RAMRepository repository) {
        super(repository);
    }
}
