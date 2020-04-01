package com.project.marketplace.service;

import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {
    private final SpecialityRepository specialityRepositor;

    public SpecialityService(SpecialityRepository specialityRepositor) {
        this.specialityRepositor = specialityRepositor;
//        this.initDB();
    }

    private void initDB() {
        Speciality speciality = new Speciality();
        speciality.setName("Abdou@gmail.com");
        speciality.setPriceSpeciality(54656);
        this.specialityRepositor.save(speciality);
    }
}
