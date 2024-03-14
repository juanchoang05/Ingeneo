package com.api.transportservices.controllers;

import com.api.transportservices.models.DeliveryPlanModel;
import com.api.transportservices.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ArrayList<DeliveryPlanModel> get(){
        return this.deliveryService.getDeliveries();
    }

    @PostMapping
    public  DeliveryPlanModel save(@RequestBody DeliveryPlanModel delivery){
        return this.deliveryService.save(delivery);
    }

    @GetMapping(path = "/{id}")
    public Optional<DeliveryPlanModel> getUserById(@PathVariable("id") Long id){
        return this.deliveryService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public DeliveryPlanModel updateById(@RequestBody DeliveryPlanModel req, @PathVariable("id") Long id){
        return this.deliveryService.updateById(req,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.deliveryService.deleteDelivery(id);
        if(ok){
            return "delivery with id" + id + "deleted!";
        }else {
            return "Error, we have a problem ";
        }
    }
}
