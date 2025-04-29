package org.suzano.rest.model.response.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModelResponse {
    private GeolocationModelResponse geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;
}
