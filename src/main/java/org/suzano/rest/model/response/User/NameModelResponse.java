package org.suzano.rest.model.response.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameModelResponse {
    private String firstname;
    private String lastname;
}
