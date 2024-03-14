package com.api.deliveryservice.feign;

import com.api.deliveryservice.model.ProductWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("TRANSPORT-SERVICE")
public interface IProduct {

    @GetMapping("product")
    public ProductWrapper getProductById(@RequestParam String id);
}
