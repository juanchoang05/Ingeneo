package com.api.transportservices.controllers;

import com.api.transportservices.models.VehicleModel;
import com.api.transportservices.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ArrayList<VehicleModel> get(){
        return this.vehicleService.getVehicle();
    }

    @PostMapping
    public  VehicleModel save(@RequestBody VehicleModel delivery){
        return this.vehicleService.save(delivery);
    }

    @GetMapping(path = "/{id}")
    public Optional<VehicleModel> getUserById(@PathVariable("id") Long id){
        return this.vehicleService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public VehicleModel updateById(@RequestBody VehicleModel req, @PathVariable("id") Long id){
        return this.vehicleService.updateById(req,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.vehicleService.deleteDelivery(id);
        if(ok){
            return "delivery with id" + id + "deleted!";
        }else {
            return "Error, we have a problem ";
        }
    }
}
