package org.suzano.rest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModelRequest {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}