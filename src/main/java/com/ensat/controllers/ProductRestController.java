package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


/**
 * Product controller.
 */
@RestController
@RequestMapping("/product-rest")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> list() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/update/{id}")
    public Product saveProduct(@RequestBody Product product, @PathVariable Integer id) {
        return productService.saveProduct(product);

    }


}