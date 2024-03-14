package com.api.transportservices.services;

import com.api.transportservices.models.VehicleModel;
import com.api.transportservices.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    public ArrayList<VehicleModel> getVehicle(){
        return  (ArrayList<VehicleModel>) vehicleRepository.findAll();
    };

    public VehicleModel save(VehicleModel VehicleModel){
        return vehicleRepository.save(VehicleModel);
    }

    public Optional<VehicleModel> getById(Long id){
        return vehicleRepository.findById(id);
    }

    public VehicleModel updateById( VehicleModel request, Long id){

        VehicleModel vehicleModel = vehicleRepository.findById(id).get();

        vehicleModel.setLogisticTypeModel(request.getLogisticTypeModel());
        vehicleModel.setName(request.getName());

        return vehicleModel;
    }

    public Boolean deleteDelivery(Long id){
        try {
            vehicleRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
