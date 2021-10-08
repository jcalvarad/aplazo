package com.aplazo.service.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistService {
    @Autowired
    PersistRepository persistRepository;
    
    public void save(Persist persist) {
        persistRepository.save(persist);
    }
}
