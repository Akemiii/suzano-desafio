package org.suzano.rest.model.response.Product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingModelResponse {
    private double rate;
    private int count;
}
