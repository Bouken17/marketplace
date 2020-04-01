package com.project.marketplace.service;

import com.project.marketplace.entity.*;
import com.project.marketplace.entity.ImageStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;

@Service
public class ImageStorageService {

    private Path fileStorageLocation;
    private final String pathFirstPart;
    @Autowired
    public ImageStorageService(ImageStorageProperties fileStorageProperties) {
        this.pathFirstPart=fileStorageProperties.getUploadDir();
    }

    public String storeImage(MultipartFile image, Long Id) {
        String imageName = StringUtils.cleanPath(image.getOriginalFilename());
        try {
            if(imageName.contains("..")) {
                throw new ImageStorageException("Sorry! Filename contains invalid path sequence " + imageName);
            }
            try {
                this.fileStorageLocation = Paths.get(this.pathFirstPart+'/'+Id.toString()).toAbsolutePath().normalize();
                Files.createDirectories(this.fileStorageLocation);
            } catch (Exception ex) {
                throw new ImageStorageException("Could not create the directory where the uploaded file will be stored.", ex);
            }
            Path targetLocation = this.fileStorageLocation.resolve(imageName);
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return imageName;
        } catch (IOException ex) {
            throw new ImageStorageException("Could not store file " + imageName + ". Please try again!", ex);
        }
    }
}
