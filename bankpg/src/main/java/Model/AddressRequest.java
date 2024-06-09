package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String address;

    private String city;

    private String postalcode;

    private String state;

    private String country;
}
