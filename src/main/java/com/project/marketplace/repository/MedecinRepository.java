package com.project.marketplace.repository;

import com.project.marketplace.entity.Complaint;
import com.project.marketplace.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
