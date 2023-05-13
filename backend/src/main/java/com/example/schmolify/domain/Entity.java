package com.example.schmolify.domain;

import java.util.Objects;

public abstract class Entity<IdType> {
    protected IdType id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!getClass().equals(obj.getClass())) {
            @SuppressWarnings("unchecked")
            Entity<IdType> that = (Entity<IdType>) obj;
            return Objects.equals(this.id, that.id);
        }
        return false;
    }

    public IdType getId() {
        return id;
    }
}
