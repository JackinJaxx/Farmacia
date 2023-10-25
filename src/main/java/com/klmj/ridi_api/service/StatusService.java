package com.klmj.ridi_api.service;

import com.klmj.ridi_api.persistence.entity.Status;
import com.klmj.ridi_api.persistence.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService extends PersistenceService<Status, Long>{
    @Autowired
    public StatusService(StatusRepository repository){super(repository);}
}
