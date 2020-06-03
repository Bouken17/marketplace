package com.project.marketplace.rest;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.service.ProductService;
import com.project.marketplace.service.SpecialityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    private final SpecialityService specialityService;

    public ProductController(ProductService productService, SpecialityService specialityService) {
        this.productService = productService;
        this.specialityService = specialityService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("productsforSpeciality/{id}")
    public List<Product> getAllProducts(@PathVariable long id) {
        Speciality speciality=null;
        speciality=this.specialityService.getSpeciality(id);
        return this.productService.getAllProductsForSpeciality(speciality);
    }

    @GetMapping("productsids")
    public List<Product> getProducts(@RequestParam("chaine") String chaine) {
        List<Product> products=new ArrayList<>();
        StringTokenizer st = new StringTokenizer(chaine, ",");
        while (st.hasMoreTokens()){
            products.add(this.productService.getProduct(Long.parseLong(st.nextToken())));
        }
        return products;
    }

}
