package com.ms.addresspg.Model;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse implements Serializable {
    private String address;

    private String city;

    private String postalcode;

    private String state;

    private String country;
}
