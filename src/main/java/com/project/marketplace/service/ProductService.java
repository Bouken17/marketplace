package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
    public List<Product> getAllProductsForSpeciality(Speciality speciality) {
        return this.productRepository.findAllBySpecialityEquals(speciality);
    }
    public Product getProduct(long id) {
        return this.productRepository.findById(id).orElseThrow();
    }
}
