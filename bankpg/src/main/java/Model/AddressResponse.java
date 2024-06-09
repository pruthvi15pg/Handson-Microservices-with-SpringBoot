package Model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
    private String address;

    private String city;

    private String postalcode;

    private String state;

    private String country;
}
