package com.project.marketplace.service;

import com.project.marketplace.repository.MedecinRepository;
import org.springframework.stereotype.Service;

@Service
public class MedecinService {
    private final MedecinRepository MedecinRepository;

    public MedecinService(MedecinRepository MedecinRepository) {
        this.MedecinRepository = MedecinRepository;
//        this.initDB();
    }
//    private void initDB() {
//        Complaint complaint = new Complaint();
//        complaint.setEmail("Abdou@gmail.com");
//        complaint.setName("CIN1");
//        complaint.setMessage("Laouali");
//        complaint.setObjet("Mahaboubou");
//        complaint.setProduct(productService.getAllProducts().get(0));
//        this.addComplaint(complaint);
//    }
//
//    public Complaint addComplaint(Complaint complaint) {
//        return this.complaintRepository.save(complaint);
//    }
    public void RequestQuotation() {

    }
}
