package com.api.deliveryservice.model;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductWrapper {

    private Long ProductId;
    private String productTypeModel;
    private Long quantity;

}
