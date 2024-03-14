package com.api.transportservices.repositories;

import com.api.transportservices.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IProductRepository  extends JpaRepository<ProductModel, Long> {



}
