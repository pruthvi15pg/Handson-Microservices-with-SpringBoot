package com.ms.addresspg.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressid;
    private String address;
    private String city;
    private String postalcode;
    private String state;
    private String country;
    @OneToOne
    private Coordinates coordinates;
//
//     "address": "1745 T Street Southeast",
//             "city": "Washington",
//             "coordinates": {
//        "lat": 38.867033,
//                "lng": -76.979235
//    },
//            "postalCode": "20020",
//            "state": "DC"

}
