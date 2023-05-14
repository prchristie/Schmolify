package com.example.schmolify.domain;

import java.util.List;

public interface SchmolRepository {
    void add(Schmol schmol);

    Schmol getById(SchmolId id);

    List<Schmol> getAll();
}
