package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
//                this.initDB();
    }
//    private void initDB() {
//        Product product = new Product();
//        product.setName("Abdou@gmail.com");
//        product.setDescription("CIN1");
//        product.setCatalogue("Laouali");
//        product.setMarque("Mahaboubou");
//        this.addProduct(product);
//    }
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
