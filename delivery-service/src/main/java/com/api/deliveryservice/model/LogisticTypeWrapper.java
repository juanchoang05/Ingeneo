package com.api.deliveryservice.model;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LogisticTypeWrapper {


    private Long logisticTypeId;
    private String logisticTypeName;
    private String wineryOrPortName;


}
