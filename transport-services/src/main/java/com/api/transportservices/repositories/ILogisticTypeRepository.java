package com.api.transportservices.repositories;

import com.api.transportservices.models.LogisticTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogisticTypeRepository extends JpaRepository<LogisticTypeModel, Long > {
}
