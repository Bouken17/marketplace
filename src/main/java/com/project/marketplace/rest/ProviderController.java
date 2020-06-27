package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.*;
import com.project.marketplace.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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

    @GetMapping("/getAllProviders")
    public List<Provider> getAllproviders(){
        return this.providerService.getAllProviders();
    }
    @GetMapping("/getProfil/{id}")
    public Provider getPRovider(@Valid @PathVariable("id") long id){
        return this.providerService.getProvider(id);
    }
    @GetMapping("/getProfilData/{login}")
    public Provider getProfilData(@Valid @PathVariable("login") String login){
        return this.providerService.getProvider(this.providerService.getProviderByEmail(login).getId());
    }
    @GetMapping("/getownedproductsbylogin/{login}")
    public List<Product> getownedproductsbylogin(@Valid @PathVariable("login") String login){
        return this.getOwnedProducts(this.providerService.getProviderByEmail(login).getId());
    }
    @PostMapping("/addproduct/{login}")
    public Product addProduct(@PathVariable("login") String login, @RequestParam("product") String productStr,@RequestParam("images") MultipartFile[] images,@RequestParam("catalogue") MultipartFile catalogue) {
        Product product = new Gson().fromJson(productStr, Product.class);
        product.setProvider(this.providerService.getProviderByEmail(login));
        Product product1= this.providerService.addProduct(product);
        this.imageStorageService.storeCatalogue(catalogue,product1);
        product1.setCatalogue(this.imageController.uploadCatalogue(product1,catalogue));
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

    @PutMapping("/updateproduct")
    public Product updateProduct(@RequestParam("product") String productStr,@RequestParam("images") MultipartFile[] images,@RequestParam("catalogue") MultipartFile catalogue) {
        Product product = new Gson().fromJson(productStr, Product.class);
      /*  StringTokenizer st = new StringTokenizer(product.getCatalogue(),"http://localhost:8080/catalogues/");
        st.nextToken();
        String chaine = st.nextToken();
        StringTokenizer st1 = new StringTokenizer(chaine,"/");
        st.nextToken();
        st.nextToken();
        String catalogueName = st.nextToken();
        if(!catalogue.equals(null) && (catalogue.getOriginalFilename()!=catalogueName)){
            this.imageStorageService.storeCatalogue(catalogue,product);
            product.setCatalogue(this.imageController.uploadCatalogue(product,catalogue));
        }
        if(!images.equals(null)) {
            List<Image> liste=Image.convertToImage(images,product);
            List<Image> temp=new ArrayList<Image>();
            for(int i=0;i<liste.size();i++)
                temp.add(new Image());
            product.setImages(temp);
            Product product1= this.providerService.updateProduct(product.getId(),product);
            for (int i=0;i<liste.size();i++) {
                liste.get(i).setId(product1.getImages().get(i).getId());
            }
            for (Image image: liste) {
                this.imageService.updateImage(image);
            }
            Product product2= this.providerService.getProduct(product1.getId());
            for ( MultipartFile image: images) {
                this.imageStorageService.storeImage(image,product);
            }
            this.imageController.uploadMultipleFiles(product2,images);
            return product2;
        }
        */
        if(!catalogue.equals(null)){
            this.imageStorageService.storeCatalogue(catalogue,product);
            product.setCatalogue(this.imageController.uploadCatalogue(product,catalogue));
        }
        if(!images.equals(null)) {
            List<Image> liste=Image.convertToImage(images,product);
            List<Image> temp=new ArrayList<Image>();
            for(int i=0;i<liste.size();i++)
                temp.add(new Image());
            product.setImages(temp);
            Product product1= this.providerService.updateProduct(product.getId(),product);
            for (int i=0;i<liste.size();i++) {
                liste.get(i).setId(product1.getImages().get(i).getId());
            }
            for (Image image: liste) {
                this.imageService.updateImage(image);
            }
            Product product2= this.providerService.getProduct(product1.getId());
            for ( MultipartFile image: images) {
                this.imageStorageService.storeImage(image,product);
            }
            this.imageController.uploadMultipleFiles(product2,images);
            return product2;
        }
        return
        this.providerService.updateProduct(product.getId(),product);
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
        provider.setDate(new Date());
        return this.adminService.addProvider(provider);
    }


    @DeleteMapping("/deleteproduct/{id}")
    public boolean deleteProduct(@Valid @PathVariable long id) {
        return  this.providerService.deleteProduct(id);
    }

    @GetMapping("/getproduct/{id}")
    public Product getProduct(@Valid @PathVariable long id) {
        return this.providerService.getProduct(id);
    }


    @GetMapping("/getallspecialitiessuscribed")
    public List<Speciality> getAllSpecialitiesSuscribed() {
        return this.providerService.getAllSpecialitiesSuscribed();
    }

    @GetMapping("/getownedproducts/{id}")
    public List<Product> getOwnedProducts(@Valid @PathVariable long id) {
        return this.providerService.getOwnedProducts(id);
    }

    @GetMapping("/getclaimedproducts/{id}")
    public List<Product> getClaimedProducts(@Valid @PathVariable long id) {
        return this.providerService.getClaimedProducts(id);
    }

    @GetMapping("/getquotations/{id}")
    public List<Product> getQuotations(@Valid @PathVariable long id) {
        return this.providerService.getQuotations(id);
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
