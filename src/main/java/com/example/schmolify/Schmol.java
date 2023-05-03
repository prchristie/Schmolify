package com.example.schmolify;

import java.net.URL;

public class Schmol {
    private final SchmolId id;
    private final URL url;

    public Schmol(SchmolId id, URL url) {
        this.id = id;
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public SchmolId getId() {
        return id;
    }
}
