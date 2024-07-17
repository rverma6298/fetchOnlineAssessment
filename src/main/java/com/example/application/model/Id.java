package com.example.application.model;

import java.util.UUID;

public class Id {
    private UUID id;

    public Id() {
    }

    public Id(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
