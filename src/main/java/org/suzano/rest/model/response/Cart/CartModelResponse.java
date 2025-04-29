package org.suzano.rest.model.response.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartModelResponse {
    private int id;
    private int userId;
    private String date;
    private List<ProductsModelResponse> products;
    private int __v;

}
