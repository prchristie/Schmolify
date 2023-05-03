package com.example.schmolify;

public interface SchmolRepository {
    void add(Schmol schmol);

    Schmol getById(SchmolId id);
}
