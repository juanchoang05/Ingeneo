package com.api.deliveryservice.service;

import com.api.deliveryservice.common.Constant;
import com.api.deliveryservice.feign.IDelivery;
import com.api.deliveryservice.feign.IProduct;
import com.api.deliveryservice.feign.IVehicle;
import com.api.deliveryservice.model.DeliveryPlanWrapper;
import com.api.deliveryservice.model.ProductWrapper;
import com.api.deliveryservice.model.VehicleWrapper;
import com.api.deliveryservice.model.wrapper.MaritimoDeliveryWrapper;
import com.api.deliveryservice.model.wrapper.TrucksDeliveryWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DeliveryService {
    IDelivery iDelivery;
    IProduct iproduct;

    IVehicle iVehicle;

    public ResponseEntity<String> createTRuckDelivery(TrucksDeliveryWrapper trucksDelivery){
        DeliveryPlanWrapper deliveryPlan = new DeliveryPlanWrapper();

        try{

            if (validatePatter(Constant.PATTERN.TRUCK,trucksDelivery.getLicensePlate()))
                throw new Exception("No cumple con El formato debe corresponder a 3 letras iniciales y 3 números\n" +
                    "finales)");


            ProductWrapper productWrapper = iproduct.getProductById(trucksDelivery.getProduct_type());
            VehicleWrapper vehicleWrapper = iVehicle.getVehicleById(trucksDelivery.getLicensePlate());



            deliveryPlan.setDeliveryDate(trucksDelivery.getDeliveryDate());
            if(productWrapper.getQuantity() > Constant.DESCUENTO.LIMIT10)
                deliveryPlan.setDeliveryPrice(trucksDelivery.getDeliveryPrice() - (trucksDelivery.getDeliveryPrice() * Constant.DESCUENTO.P03));

            deliveryPlan.setGuideNumber(trucksDelivery.getGuideNumber());
            deliveryPlan.setProductModel(productWrapper);
            deliveryPlan.setVehicleModel(vehicleWrapper);
            deliveryPlan.setRegisterDate(trucksDelivery.getRegisterDate());


            iDelivery.createMaritimoDelivery(deliveryPlan);

            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> createMaritimoDelivery(MaritimoDeliveryWrapper maritimoDelivery){
        DeliveryPlanWrapper deliveryPlan = new DeliveryPlanWrapper();

        try{

            if (validatePatter(Constant.PATTERN.MARITIMO,maritimoDelivery.getFleetNumber())) throw new Exception("No cumple con 3 letras iniciales, seguidas de 4\n" +
                    "números y finalizando con una letra)");


            ProductWrapper productWrapper = iproduct.getProductById(maritimoDelivery.getProduct_type());
            VehicleWrapper vehicleWrapper = iVehicle.getVehicleById(maritimoDelivery.getPortDelivery());

            deliveryPlan.setDeliveryDate(maritimoDelivery.getDeliveryDate());
            if(productWrapper.getQuantity() > Constant.DESCUENTO.LIMIT10)
                deliveryPlan.setDeliveryPrice(maritimoDelivery.getDeliveryPrice() - (maritimoDelivery.getDeliveryPrice() * Constant.DESCUENTO.P05));            deliveryPlan.setGuideNumber(maritimoDelivery.getGuideNumber());
            deliveryPlan.setProductModel(productWrapper);
            deliveryPlan.setVehicleModel(vehicleWrapper);
            deliveryPlan.setRegisterDate(maritimoDelivery.getRegisterDate());


            iDelivery.createMaritimoDelivery(deliveryPlan);

            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }

    }

    private Boolean validatePatter(String pattern , String input){

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
