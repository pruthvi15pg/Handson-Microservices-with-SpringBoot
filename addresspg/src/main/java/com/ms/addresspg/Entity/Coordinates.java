package com.ms.addresspg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coordinates {
    @Id
    private int id;

    private double longitude;

    private double latitude;
}
