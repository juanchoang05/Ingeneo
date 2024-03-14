package com.api.deliveryservice.feign;

import com.api.deliveryservice.model.ProductWrapper;
import com.api.deliveryservice.model.VehicleWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("TRANSPORT-SERVICE")
public interface IVehicle {

    @GetMapping("vehicle")
    public VehicleWrapper getVehicleById(@RequestParam String name);
}
