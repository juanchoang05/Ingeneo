package com.api.deliveryservice.model.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TrucksDeliveryWrapper {

    private String product_type;
    private Long quantity;
    private Date registerDate;
    private Date deliveryDate;
    private String wineryDelivery;
    private Long deliveryPrice;
    private String licensePlate;
    private String guideNumber;


}
