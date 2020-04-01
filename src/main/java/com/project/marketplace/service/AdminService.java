package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.AdminRepository;
import com.project.marketplace.repository.ProductRepository;
import com.project.marketplace.repository.ProviderRepository;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final ProviderRepository providerRepository;
    private final ProductRepository productRepository;
    private final SpecialityRepository specialityRepository;

    public AdminService(ProviderRepository providerRepository, ProductRepository productRepository, SpecialityRepository specialityRepository) {
        this.providerRepository = providerRepository;
        this.productRepository = productRepository;
        this.specialityRepository = specialityRepository;
//        this.initDB();
    }

    private void initDB() {
        for(int i=0;i<10;i++){
            Provider provider = new Provider();
            provider.setFirstname("Provider " + ( i + 1 ) + " FirstName ");
            provider.setLastname("Provider " + ( i + 1 ) + " LastName ");
            provider.setEmail("Provider " + ( i + 1 ) + " Mail ");
            provider.setPassword("Provider " + ( i + 1 ) + " Password ");
            provider.setStatus(1);
            provider.setType(true);
            this.addProvider(provider);
        }
    }


    public boolean addProvider(Provider provider) {
        this.providerRepository.save(provider);
        return true;
    }

    public boolean blockProduct(long product, long provider) {
        Product product1 = this.productRepository.findById(product).orElseThrow();
        if(!product1.equals(null)){
            product1.setBlocked(true);
            return true;
        }
        return false;
    }

    public boolean blockProvider(long provider) {
        Provider provider1 = this.providerRepository.findById(provider).orElseThrow();
        if(!provider1.equals(null)){
            provider1.setStatus(-1);
            return true;
        }
        return false;
    }

    public boolean addSpeciality(Speciality speciality) {
        this.specialityRepository.save(speciality);
        return true;
    }

    public boolean deleteSpeciality(long id) {
        this.specialityRepository.deleteById(id);
        return !true;
    }

}
