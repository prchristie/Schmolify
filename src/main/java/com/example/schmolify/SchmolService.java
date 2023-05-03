package com.example.schmolify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class SchmolService {
    @Autowired
    private SchmolRepository schmolRepository;
    @Autowired
    private SchmolIdFactory schmolIdFactory;

    public Schmol createSchmol(URL url) throws MalformedURLException {
        Schmol schmol = new Schmol(schmolIdFactory.idFromUrl(url), url);
        schmolRepository.add(schmol);
        return schmol;
    }

    public Schmol getSchmol(SchmolId id) {
        return schmolRepository.getById(id);
    }
}
