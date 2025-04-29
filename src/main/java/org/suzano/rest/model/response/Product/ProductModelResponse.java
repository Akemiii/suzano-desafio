package org.suzano.rest.model.response.Product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModelResponse {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingModelResponse rating;
}