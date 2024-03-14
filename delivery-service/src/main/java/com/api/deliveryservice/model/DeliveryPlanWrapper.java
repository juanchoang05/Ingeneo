package com.api.deliveryservice.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class DeliveryPlanWrapper {


    private Long deliveryPlanId;
    private ProductWrapper productModel;
    private Date registerDate;
    private Date deliveryDate;
    private Double deliveryPrice;
    private VehicleWrapper vehicleModel;
    private String guideNumber;

}
