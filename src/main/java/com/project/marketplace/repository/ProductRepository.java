package com.project.marketplace.repository;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProviderEquals(Provider provider);
    List<Product> findAllBySpecialityEquals(Speciality speciality);
    Product findFirstByOrderByNombreVueDesc();
}
