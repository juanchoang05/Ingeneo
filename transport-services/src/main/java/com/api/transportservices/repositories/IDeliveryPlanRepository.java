package com.api.transportservices.repositories;

import com.api.transportservices.models.DeliveryPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryPlanRepository extends JpaRepository<DeliveryPlanModel, Long> {
}
