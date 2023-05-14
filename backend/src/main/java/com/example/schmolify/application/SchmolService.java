package com.example.schmolify.application;

import com.example.schmolify.domain.Schmol;
import com.example.schmolify.domain.SchmolId;
import com.example.schmolify.domain.SchmolIdFactory;
import com.example.schmolify.domain.SchmolRepository;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;

@Service
public class SchmolService {
    private final SchmolRepository schmolRepository;
    private final SchmolIdFactory schmolIdFactory;

    public SchmolService(SchmolRepository schmolRepository, SchmolIdFactory schmolIdFactory) {
        this.schmolRepository = schmolRepository;
        this.schmolIdFactory = schmolIdFactory;
    }

    public Schmol createSchmol(String url) throws MalformedURLException {
        Schmol schmol = new Schmol(schmolIdFactory.idFromUrl(url), url);
        schmolRepository.add(schmol);
        return schmol;
    }

    public Schmol getSchmol(String schmolId) {
        return schmolRepository.getById(SchmolId.create(schmolId));
    }

    public List<Schmol> getAllSchmols() {
        return schmolRepository.getAll();
    }
}
