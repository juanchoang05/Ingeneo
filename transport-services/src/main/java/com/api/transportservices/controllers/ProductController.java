package com.api.transportservices.controllers;

import com.api.transportservices.models.ProductModel;
import com.api.transportservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<ProductModel> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public  ProductModel saveProduct(@RequestBody ProductModel product){
        return this.productService.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getUserById(@PathVariable("id") Long id){
            return this.productService.getById(id);
        }

    @PutMapping(path = "/{id}")
    public ProductModel updateProductById(@RequestBody ProductModel req, @PathVariable("id") Long id){
        return this.productService.updateById(req,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.productService.deleteProduct(id);
        if(ok){
            return "Product with id" + id + "deleted!";
        }else {
            return "Error, we have a problem ";
        }
    }

}
