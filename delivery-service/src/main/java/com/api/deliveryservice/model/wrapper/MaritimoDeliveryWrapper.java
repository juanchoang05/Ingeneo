package com.api.deliveryservice.model.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MaritimoDeliveryWrapper {

    private String product_type;
    private Long quantity;
    private Date registerDate;
    private Date deliveryDate;
    private String PortDelivery;
    private Long deliveryPrice;
    private String fleetNumber;
    private String guideNumber;


}
