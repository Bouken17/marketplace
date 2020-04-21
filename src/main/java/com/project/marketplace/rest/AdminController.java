package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.Image;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.service.ImageService;
import com.project.marketplace.service.ImageStorageService;
import com.project.marketplace.service.ProviderService;
import com.project.marketplace.service.ProxyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final ProviderService providerService;
    private final ProxyAdmin proxyAdmin;
    private final ImageController imageController;
    private final ImageService imageService;
    @Autowired
    private ImageStorageService imageStorageService;

    public AdminController(ProviderService providerService, ProxyAdmin proxyAdmin, ImageController imageController, ImageService imageService) {
        this.providerService = providerService;
        this.proxyAdmin = proxyAdmin;
        this.imageController = imageController;
        this.imageService = imageService;
    }
    @GetMapping("/login/{admin}")
//    public boolean login(@RequestParam("type") boolean type, @RequestParam("login") String login, @RequestParam("password") String password){
    public boolean login(@Valid @PathVariable("admin") String admin, @Valid @RequestParam("login") String login, @Valid @RequestParam("password") String password){
        Provider provider=null;
        if (admin.equals("admin")) {
            provider = this.providerService.getAdmin();
        }else{
            provider = this.providerService.getProvider(login);
        }
        if(provider == null)
            return false;
        if(provider.getPassword().equals(password))
            return true;
        return false;
    }
}
