package com.ms.bankpg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressid;

    private String address;

    private String city;

    private String postalcode;

    private String state;

    private String country;


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
