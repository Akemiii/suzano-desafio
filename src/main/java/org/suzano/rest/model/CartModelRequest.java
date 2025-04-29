package org.suzano.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartModelRequest {
    private int id;
    private int userId;
    private List<ProductModelRequest> products;
}
