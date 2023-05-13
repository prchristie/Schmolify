package com.example.schmolify.domain;

import java.net.URL;

public class Schmol extends Entity<SchmolId> {
    private final URL url;

    public Schmol(SchmolId id, URL url) {
        this.id = id;
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }
}
