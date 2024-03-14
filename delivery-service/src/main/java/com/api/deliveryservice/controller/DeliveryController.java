package com.api.deliveryservice.controller;

import com.api.deliveryservice.model.wrapper.MaritimoDeliveryWrapper;
import com.api.deliveryservice.model.wrapper.TrucksDeliveryWrapper;
import com.api.deliveryservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("deliveryManagement")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("createMaritimoDelivery")
    public ResponseEntity<String> createDelivery(@RequestBody MaritimoDeliveryWrapper delivery){
        return deliveryService.createMaritimoDelivery(delivery);
    }

    @PostMapping("createTruckDelivery")
    public ResponseEntity<String> createDelivery(@RequestBody TrucksDeliveryWrapper delivery){
        return deliveryService.createTRuckDelivery(delivery);
    }
}
