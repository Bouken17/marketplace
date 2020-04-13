package com.project.marketplace.rest;

import com.google.gson.Gson;
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

    @GetMapping("/getProfil/{id}")
    public Provider getPRovider(@Valid @PathVariable("id") long id){
        return this.providerService.getProvider(id);
    }
    @PostMapping("/addproduct")
    public Product addProduct(@Valid @RequestParam("product") String productStr,@Valid @RequestParam("images") MultipartFile[] images) { System.out.println(" images nb: "+images.length);
//        System.out.println(" product: "+productStr);
//        System.out.println(" images nb: "+images[0].getOriginalFilename());
        Product product = new Gson().fromJson(productStr, Product.class);
        Product product1= this.providerService.addProduct(product);
        product1.setImages(new Image().convertToImage(images,product));
        Product product2= this.providerService.addProduct(product1);
        for ( MultipartFile image: images) {
            this.imageStorageService.storeImage(image,product);
        }
        this.imageController.uploadMultipleFiles(product1,images);
        return product2;
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
