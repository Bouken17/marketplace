package com.project.marketplace.rest;

import com.project.marketplace.entity.Image;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.service.ImageStorageService;
import com.project.marketplace.service.ProviderService;
import com.project.marketplace.service.ProxyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {
    private final ProviderService providerService;
    private final ProxyAdmin proxyAdmin;
    private final ImageController imageController;
    @Autowired
    private ImageStorageService imageStorageService;

    public ProviderController(ProviderService providerService, ProxyAdmin proxyAdmin, ImageController imageController) {
        this.providerService = providerService;
        this.proxyAdmin = proxyAdmin;
        this.imageController = imageController;
    }

    @PutMapping("/updateProfil")
    public boolean updateProfil(@Valid @PathVariable long id, @Valid @RequestBody Provider provider) {
        return this.providerService.updateProfil(id,provider);
    }

    @PostMapping("/addproduct")
    public Product addProduct(@Valid @RequestParam("produit") Product product, @Valid @RequestParam("images") MultipartFile[] images) {
//    public Product addProduct(@Valid @RequestParam("produit") String productName, @Valid @RequestParam("images") MultipartFile[] images) {
//        Product product=new Product();
//        product.setName(productName);
//        product.setImages(new Image().convertToImage(images,product.getName().replace(" ","_"),1));
        product.setImages(new Image().convertToImage(images,product.getName().replace(" ","_"),product.getProvider().getId()));
        Product product1= this.providerService.addProduct(product);
        for ( MultipartFile image: images) {
            this.imageStorageService.storeImage(image,product.getProvider().getId(),product.getName().replace(" ","_"));
//            imageStorageService.storeImage(image,1,product.getName().replace(" ","_"));
        }
//        this.imageController.uploadMultipleFiles(product1.getId(),images);
        return product1;
    }

    @PutMapping("/updateproduct")
    public Product updateProduct(@Valid @PathVariable long idProduct, @Valid @RequestBody Product newProduct) {
        return this.providerService.updateProduct(idProduct,newProduct);
    }

    @DeleteMapping("/deleteproduct")
    public boolean deleteProduct(@Valid @PathVariable long id) {
        return  this.providerService.deleteProduct(id);
    }

    @GetMapping("/getproduct/{id}")
    public Product getProduct(@Valid @PathVariable long id) {
        return this.providerService.getProduct(id);
    }

    @GetMapping("/specialities")
    public List<Speciality> getAllSpecialitys() {
        return this.providerService.getAllSpecialitys();
    }
}
