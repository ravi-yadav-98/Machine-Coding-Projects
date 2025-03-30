package com.productservices.productservices.controllers;

import com.productservices.productservices.dtos.FakeStoreDto;
import com.productservices.productservices.dtos.GenricProductDto;
import com.productservices.productservices.services.FakeStoreProductService;
import com.productservices.productservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Rest API  @Controller means : Simple Object of controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    // Optional
    //Constructor Injection
//    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService)
//    {
//        this.productService= productService;
//    }

    @GetMapping("/{id}")
    public GenricProductDto getProductById (@PathVariable("id") Long id){
        //call the fakeStoreProductService getProductByid()

        return  productService.getProductById(id);
    }
    @GetMapping
    public List<GenricProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public   GenricProductDto deleteProductById(){
    }
    @PostMapping
    public GenricProductDto createProduct(@RequestBody GenricProductDto genricProductDto){
        return productService.createProduct(genricProductDto);
    }
    public void updateProductById(){

    }

}



/*
Three ways of Dependency Injection
1. Constructor Injection
2. Field Injection  @Autowire at top of field : Less readable
3. Setter Injection
 */