package com.damithdev.controller;

import com.damithdev.Prod;
import com.damithdev.Product;
import com.damithdev.service.PriceCalService;
import com.damithdev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    Collection<Product> getGroups() {

         return productService.productsList();
    }

    @PostMapping(value = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    double groups(@RequestBody List<Prod> products) {

        return productService.calTotal(products);
    }

}
