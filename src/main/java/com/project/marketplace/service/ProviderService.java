package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.ProductRepository;
import com.project.marketplace.repository.ProviderRepository;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final SpecialityRepository specialityRepository;
    private final ProductRepository productRepository;

    public ProviderService(ProviderRepository providerRepository, SpecialityRepository specialityRepository, ProductRepository productRepository) {
        this.providerRepository = providerRepository;
        this.specialityRepository = specialityRepository;
        this.productRepository = productRepository;
//        this.initDB();
    }

//    private void initDB() {
//        Provider provider = new Provider();
//        provider.setFirstname("Abdou@gmail.com");
//        provider.setLastname("CIN1");
//        provider.setEmail("Laouali");
//        provider.setPassword("Mahaboubou");
//        provider.setStatus(1);
//        provider.setType(true);
//        this.updateProfil(provider);
//    }

    public boolean updateProfil(Provider provider) {
    this.providerRepository.findById(provider.getId());
    this.providerRepository.save(provider);
    return true;
    }


    /*Start product */
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Product updateProduct(long idProduct, Product newProduct) {
        Product oldProduct = getProduct(idProduct);
        if(oldProduct!=null){
            newProduct.setId(idProduct);
            return this.productRepository.save(newProduct);
        }
        return null;
    }

    public boolean deleteProduct(long id) {
        this.productRepository.deleteById(id);
        return true;
    }

    public Product getProduct(long id) {
        return this.productRepository.findById(id).orElseThrow();
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
