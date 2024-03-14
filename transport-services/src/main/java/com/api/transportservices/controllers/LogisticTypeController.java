package com.api.transportservices.controllers;

import com.api.transportservices.models.DeliveryPlanModel;
import com.api.transportservices.models.LogisticTypeModel;
import com.api.transportservices.services.LogisticTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/logisticType")
public class LogisticTypeController {

    @Autowired
    private LogisticTypeService logisticTypeService;

    @GetMapping
    public ArrayList<LogisticTypeModel> get(){
        return this.logisticTypeService.getLogistic();
    }

    @PostMapping
    public  LogisticTypeModel save(@RequestBody LogisticTypeModel delivery){
        return this.logisticTypeService.saveLogistic(delivery);
    }

    @GetMapping(path = "/{id}")
    public Optional<LogisticTypeModel> getUserById(@PathVariable("id") Long id){
        return this.logisticTypeService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public LogisticTypeModel updateById(@RequestBody LogisticTypeModel req, @PathVariable("id") Long id){
        return this.logisticTypeService.updateById(req,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.logisticTypeService.delete(id);
        if(ok){
            return "delivery with id" + id + "deleted!";
        }else {
            return "Error, we have a problem ";
        }
    }
}
