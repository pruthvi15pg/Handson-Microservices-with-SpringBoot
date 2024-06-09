package com.ms.addresspg.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest implements Serializable {

    private String address;

    private String city;

    private String postalcode;

    private String state;

    private String country;
}
