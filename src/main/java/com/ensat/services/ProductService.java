package com.ensat.services;

import com.ensat.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Optional<Product> getProductById(Integer id);

    Product saveProduct(Product product);

    void saveProductWithImage(Product product, MultipartFile file);

    void deleteProduct(Integer id);

}
