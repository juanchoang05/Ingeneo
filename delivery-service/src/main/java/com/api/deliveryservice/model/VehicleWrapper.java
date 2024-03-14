package com.api.deliveryservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class VehicleWrapper {


    private Long vehicleId;
    private String name;//licensePlate or fleetNumber
    private LogisticTypeWrapper logisticTypeModel;


}
