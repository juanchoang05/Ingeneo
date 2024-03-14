package com.api.transportservices.controllers;

import com.api.transportservices.models.UserModel;
import com.api.transportservices.models.VehicleModel;
import com.api.transportservices.services.UserService;
import com.api.transportservices.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> get(){
        return this.userService.getUser();
    }

    @PostMapping
    public  UserModel save(@RequestBody UserModel user){
        return this.userService.save(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateById(@RequestBody UserModel req, @PathVariable("id") Long id){
        return this.userService.updateById(req,id);
    }
}
