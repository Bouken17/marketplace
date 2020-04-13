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
        this.specialityRepositor.save(new Speciality("Allergologie",500));
        this.specialityRepositor.save(new Speciality("Immunologie",500));
        this.specialityRepositor.save(new Speciality("anesthésiologie",500));
        this.specialityRepositor.save(new Speciality("andrologie",500));
        this.specialityRepositor.save(new Speciality("cardiologie",500));
        this.specialityRepositor.save(new Speciality("chirurgie cardiaque",500));
        this.specialityRepositor.save(new Speciality("chirurgie plastique ",500));
        this.specialityRepositor.save(new Speciality("chirurgie générale",500));
        this.specialityRepositor.save(new Speciality("chirurgie maxillo-faciale",500));
        this.specialityRepositor.save(new Speciality("chirurgie pédiatrique",500));
        this.specialityRepositor.save(new Speciality("chirurgie thoracique",500));
        this.specialityRepositor.save(new Speciality("chirurgie vasculaire",500));
        this.specialityRepositor.save(new Speciality("neurochirurgie",500));
        this.specialityRepositor.save(new Speciality("dermatologie",500));
        this.specialityRepositor.save(new Speciality("endocrinologie",500));
        this.specialityRepositor.save(new Speciality("gastro-entérologie",500));
        this.specialityRepositor.save(new Speciality("gastro-entérologie",500));
        this.specialityRepositor.save(new Speciality("gynécologie",500));
        this.specialityRepositor.save(new Speciality("hématologie",500));
        this.specialityRepositor.save(new Speciality("hépatologie",500));
        this.specialityRepositor.save(new Speciality("infectiologie",500));
        this.specialityRepositor.save(new Speciality("médecine aiguë",500));
        this.specialityRepositor.save(new Speciality("médecine du travail",500));
        this.specialityRepositor.save(new Speciality("médecine générale",500));
        this.specialityRepositor.save(new Speciality("médecine interne",500));
        this.specialityRepositor.save(new Speciality("médecine nucléaire",500));
        this.specialityRepositor.save(new Speciality("médecine palliative",500));
        this.specialityRepositor.save(new Speciality("médecine physique",500));
        this.specialityRepositor.save(new Speciality("médecine préventive",500));
        this.specialityRepositor.save(new Speciality("néonatologie",500));
        this.specialityRepositor.save(new Speciality("néphrologie",500));
        this.specialityRepositor.save(new Speciality("neurologie",500));
        this.specialityRepositor.save(new Speciality("odontologie",500));
        this.specialityRepositor.save(new Speciality("oncologie",500));
        this.specialityRepositor.save(new Speciality("obstétrique",500));
        this.specialityRepositor.save(new Speciality("ophtalmologie",500));
        this.specialityRepositor.save(new Speciality("orthopédie",500));
        this.specialityRepositor.save(new Speciality("Oto-rhino-laryngologie",500));
        this.specialityRepositor.save(new Speciality("pédiatrie",500));
        this.specialityRepositor.save(new Speciality("pneumologie",500));
        this.specialityRepositor.save(new Speciality("psychiatrie",500));
        this.specialityRepositor.save(new Speciality("radiologie",500));
        this.specialityRepositor.save(new Speciality("radiothérapie",500));
        this.specialityRepositor.save(new Speciality("rhumatologie",500));
        this.specialityRepositor.save(new Speciality("urologie",500));
    }
}
