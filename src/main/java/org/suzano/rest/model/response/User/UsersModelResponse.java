package org.suzano.rest.model.response.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties (ignoreUnknown = true)
public class UsersModelResponse {
    private List<UserModelResponse> users;
}
