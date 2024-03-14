package com.api.transportservices.services;

import com.api.transportservices.models.ProductModel;
import com.api.transportservices.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public ArrayList<ProductModel> getProducts(){
        return  (ArrayList<ProductModel>) productRepository.findAll();
    };

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id){
        return productRepository.findById(id);
    }

    public ProductModel updateById( ProductModel request, Long id){

        ProductModel product = productRepository.findById(id).get();

        product.setProductTypeModel(request.getProductTypeModel());
        product.setQuantity(request.getQuantity());

        return product;
    }

    public Boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
