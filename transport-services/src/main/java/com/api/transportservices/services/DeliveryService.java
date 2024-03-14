package com.api.transportservices.services;

import com.api.transportservices.models.DeliveryPlanModel;
import com.api.transportservices.repositories.IDeliveryPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DeliveryService {


    @Autowired
    IDeliveryPlanRepository deliveryPlanRepository;

    public ArrayList<DeliveryPlanModel> getDeliveries(){
        return  (ArrayList<DeliveryPlanModel>) deliveryPlanRepository.findAll();
    };

    public DeliveryPlanModel save(DeliveryPlanModel deliveryPlanModel){
        return deliveryPlanRepository.save(deliveryPlanModel);
    }

    public Optional<DeliveryPlanModel> getById(Long id){
        return deliveryPlanRepository.findById(id);
    }

    public DeliveryPlanModel updateById( DeliveryPlanModel request, Long id){

        DeliveryPlanModel deliveryPlanModel = deliveryPlanRepository.findById(id).get();

        deliveryPlanModel.setDeliveryDate(request.getDeliveryDate());
        deliveryPlanModel.setDeliveryPrice(request.getDeliveryPrice());
        deliveryPlanModel.setLogisticTypeModel(request.getLogisticTypeModel());
        deliveryPlanModel.setVehicleModel(request.getVehicleModel());
        deliveryPlanModel.setGuideNumber(request.getGuideNumber());
        deliveryPlanModel.setRegisterDate(request.getRegisterDate());
        return deliveryPlanModel;
    }

    public Boolean deleteDelivery(Long id){
        try {
            deliveryPlanRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
