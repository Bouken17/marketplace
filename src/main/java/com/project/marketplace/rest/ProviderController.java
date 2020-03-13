package com.project.marketplace.rest;

import com.project.marketplace.entity.Product;
import com.project.marketplace.service.ProviderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/Provider")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping("/add")
    public Product addAllProduct(@Valid @RequestBody Product product) {
        return this.providerService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable long id,@RequestBody Product product){
        return this.providerService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductById(@PathVariable long id) {
        this.providerService.deleteProduct(id);
        return true;
    }

    @GetMapping("/{id}")
    public Product getProductById(long id) {
        return this.providerService.getProduct(id);
    }
}
