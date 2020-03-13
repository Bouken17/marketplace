package com.project.marketplace.service;

import com.project.marketplace.entity.Image;
import com.project.marketplace.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        this.initDB();
    }
    private void initDB() {
        Image image = new Image();
        image.setName("image1");
        image.setPath("chemin ");
        image.setIdProduct(1);
        this.addImage(image);
    }
    public Image getImage(Long id) {
        return this.imageRepository.findById(id).orElseThrow();
    }

    public List<Image> getAllImages() {
        return this.imageRepository.findAll();
    }

    public Image addImage(Image image) {
        return this.imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        this.imageRepository.deleteById(id);
    }
}
