package org.suzano.rest.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModelRequest {
    private int id;
    private String username;
    private String email;
    private String password;
}
