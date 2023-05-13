package com.example.schmolify.domain;

public interface SchmolRepository {
    void add(Schmol schmol);

    Schmol getById(SchmolId id);
}
