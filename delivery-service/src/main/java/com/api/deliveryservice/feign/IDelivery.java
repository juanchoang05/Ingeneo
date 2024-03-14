package com.api.deliveryservice.feign;

import com.api.deliveryservice.model.DeliveryPlanWrapper;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("TRANSPORT-SERVICE")
public interface IDelivery {

    @PostMapping("delivery")
    public ResponseEntity<DeliveryPlanWrapper> createMaritimoDelivery(@RequestBody DeliveryPlanWrapper  deliveryPlan);


}
