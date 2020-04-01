package com.project.marketplace.rest;

import com.project.marketplace.entity.*;
import com.project.marketplace.service.ImageStorageService;
import com.project.marketplace.service.ImageService;
import com.project.marketplace.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    private final ImageService imageService;
    private final ProductService productService;
    @Autowired
    private ImageStorageService imageStorageService;

    public ImageController(ImageService imageService, ProductService clientService) {
        this.imageService = imageService;
        this.productService = clientService;
    }

        @GetMapping("/load/{id}")
    public String getPath(@PathVariable Long id) {
        return this.imageService.getImage(id);
    }

//    @GetMapping("/loadClientImage/{id}")
//    public String getClientImagePath(@PathVariable Long id) {
//        return this.imageService.getImageByClientId(id);
//    }

    @PostMapping("/uploadImage/{id}")
    public String uploadFile(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {

        String fileName = imageStorageService.storeImage(file,id);
        Image image = new Image(file,id);
        this.imageService.addImage(image);
        return image.getPath();
    }

    @PostMapping("/upload-multiple-images/{id}")
    @ResponseBody
    public String uploadMultipleFiles(@PathVariable("id") long id, @RequestParam("images") MultipartFile[] images) {
        return Arrays.stream(images)
                .map(file -> uploadFile(id,file))
                .collect(Collectors.toList()).toString();
    }
}
