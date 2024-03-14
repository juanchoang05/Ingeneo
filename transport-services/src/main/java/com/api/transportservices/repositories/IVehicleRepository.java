package com.api.transportservices.repositories;

import com.api.transportservices.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<VehicleModel, Long> {

}
