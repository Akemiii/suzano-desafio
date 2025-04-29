package org.suzano.rest.model.response.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModelResponse {
    private AddressModelResponse address;
    private int id;
    private String email;
    private String username;
    private String password;
    private NameModelResponse name;
    private String phone;
    private int __v;
}
