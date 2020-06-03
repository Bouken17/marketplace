package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.*;
import com.project.marketplace.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {
    private final ProviderService providerService;
    private final ProxyAdmin proxyAdmin;
    private final ImageController imageController;
    private final ImageService imageService;
    private final AdminService adminService;
    private final SpecialityService specialityService;
    @Autowired
    private ImageStorageService imageStorageService;

    public ProviderController(ProviderService providerService, ProxyAdmin proxyAdmin, ImageController imageController, ImageService imageService, AdminService adminService, SpecialityService specialityService) {
        this.providerService = providerService;
        this.proxyAdmin = proxyAdmin;
        this.imageController = imageController;
        this.imageService = imageService;
        this.adminService = adminService;
        this.specialityService = specialityService;
    }

    @PutMapping("/updateProfil")
    public boolean updateProfil(@Valid @PathVariable long id, @Valid @RequestBody Provider provider) {
        return this.providerService.updateProfil(id,provider);
    }

    @GetMapping("/getProfil/{id}")
    public Provider getPRovider(@Valid @PathVariable("id") long id){
        return this.providerService.getProvider(id);
    }
    @PostMapping("/addproduct/{id}")
    public Product addProduct(@PathVariable("id") long id, @RequestParam("product") String productStr,@RequestParam("images") MultipartFile[] images) {
        Product product = new Gson().fromJson(productStr, Product.class);
//        System.out.println(getPRovider(id).getFirstname());
        product.setProvider(getPRovider(id));
        Product product1= this.providerService.addProduct(product);
        List<Image> liste=Image.convertToImage(images,product1);
        List<Image> temp=new ArrayList<Image>();
        for(int i=0;i<liste.size();i++)
            temp.add(new Image());
        product1.setImages(temp);
        Product product2= this.providerService.updateProduct(product1.getId(),product1);
        for (int i=0;i<liste.size();i++) {
            liste.get(i).setId(product2.getImages().get(i).getId());
        }
        for (Image image: liste) {
            this.imageService.updateImage(image);
        }
        Product product3= this.providerService.getProduct(product2.getId());
        for ( MultipartFile image: images) {
            this.imageStorageService.storeImage(image,product);
        }
        this.imageController.uploadMultipleFiles(product3,images);
        return product3;
    }

    @PostMapping("/register")
    public Provider register(@RequestParam("data") String data,@RequestParam("specialities") String[] specialities,
                            @RequestParam("society") String society ) {
        Provider provider = new Gson().fromJson(data, Provider.class);
        List<Speciality> specialities1 = new ArrayList<>();
        for (String speciality: specialities) {
            specialities1.add(new Gson().fromJson(speciality, Speciality.class));
        }
        if(!society.equals("")){
            Society society1 = new Gson().fromJson(society, Society.class);
            provider.setSociety(society1);
            provider.setType(true);
        }else {
            provider.setType(false);
        }
        if(specialities1.size()>0){
            provider.setSpecialities(specialities1);
        }
        return this.adminService.addProvider(provider);
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

    @GetMapping("/getownedproducts/{id}")
    public List<Product> getOwnedProducts(@Valid @PathVariable long id) {
        return this.providerService.getOwnedProducts(id);
    }

    @GetMapping("/specialities")
    public List<Speciality> getAllSpecialities() {
        return this.providerService.getAllSpecialitys();
    }

    @GetMapping("/speciality/{id}")
    public Speciality getAllSpeciality(@PathVariable("id") long id) {
        return this.specialityService.getSpeciality(id);
    }
}
