package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Society;
import com.project.marketplace.repository.SocietyRepository;
import org.springframework.stereotype.Service;

@Service
public class SocietyService {

    private final SocietyRepository societyrRepository;

    public SocietyService(SocietyRepository societyrRepository) {
        this.societyrRepository = societyrRepository;
        this.initDB();
    }

    private void initDB() {
        Society society = new Society();
        society.setName("Abdou@gmail.com");
        society.setNumero_tel("CIN1");
        society.setEmail("Laouali");
        this.addSociety(society);
    }


    public Society addSociety(Society society) {
        return this.societyrRepository.save(society);
    }
}
