package com.project.marketplace.service;

import com.project.marketplace.entity.Image;
import com.project.marketplace.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
//    private final ProductService productService;

    public ImageService(ImageRepository imageRepository, ProductService productService) {
        this.imageRepository = imageRepository;
//        this.productService = productService;
//        this.initDB();
    }
//    private void initDB() {
//        Image image = new Image();
//        image.setName("image1");
//        image.setPath("chemin ");
//        image.setProduct(productService.getAllProducts().get(0));
//        this.addImage(image);
//    }
//
//    public Image addImage(Image image) {
//        return this.imageRepository.save(image);
//    }
}
