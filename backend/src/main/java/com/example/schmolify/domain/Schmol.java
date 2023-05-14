package com.example.schmolify.domain;

import java.net.URL;

public class Schmol extends Entity<SchmolId> {
    private final String url;

    public Schmol(SchmolId id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
