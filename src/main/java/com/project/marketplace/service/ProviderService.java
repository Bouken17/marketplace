package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.ProviderRepository;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final SpecialityRepository specialityRepository;
    private  ProductService productService;
    private SpecialityService specialityService;

    public ProviderService(ProviderRepository providerRepository, SpecialityRepository specialityRepository) {
        this.providerRepository = providerRepository;
        this.specialityRepository = specialityRepository;
        this.initDB();
    }

    private void initDB() {
        Provider provider = new Provider();
        provider.setFirstname("Abdou@gmail.com");
        provider.setLastname("CIN1");
        provider.setEmail("Laouali");
        provider.setPassword("Mahaboubou");
        provider.setStatus(1);
        provider.setType(true);
        this.updateProfil(provider);
    }

    public boolean updateProfil(Provider provider) {
    this.providerRepository.findById(provider.getId());
    this.providerRepository.save(provider);
    return true;
    }


    /*Start product */
    public Product addProduct(Product product) {
        return this.productService.addProduct(product);
    }

    public Product updateProduct(long idProduct, Product product) {
        return this.productService.addProduct(product);
    }

    public boolean deleteProduct(long id) {
        this.productService.deleteProduct(id);
        return true;
    }

    public Product getProduct(long id) {
        return this.productService.getProduct(id);
    }

    public Product[] getOwnedProducts() {
        throw new UnsupportedOperationException();
    }
    /*End product */

    /*Start speciality */
    public boolean addSpeciality(Speciality speciality) {
        this.specialityRepository.save(speciality);
        return true;
    }

    public boolean updateSubscription(int subscription) {
        throw new UnsupportedOperationException();
    }

    public Speciality[] getAllSpecialitys() {throw new UnsupportedOperationException();
    }

    public boolean deleteSpeciality() {
        throw new UnsupportedOperationException();
    }

    /*End speciality */
}
