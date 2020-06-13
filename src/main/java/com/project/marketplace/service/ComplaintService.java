package com.project.marketplace.service;

import com.project.marketplace.entity.Complaint;
import com.project.marketplace.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    private final ComplaintRepository complaintRepository;
    private final ProductService productService;

    public ComplaintService(ComplaintRepository complaintRepository, ProductService productService) {
        this.complaintRepository = complaintRepository;
        this.productService = productService;
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

    public  List<Complaint> getAllComplaints(){ return  this.complaintRepository.findAll();}
    public  Complaint getComplaint(long id){ return  this.complaintRepository.findById(id).orElseThrow();}
    public  List<Complaint> getComplaintOfProduct(long id){ return  this.complaintRepository.findAllByProductEquals(this.productService.getProduct(id));}
    public Complaint addComplaint(Complaint complaint) {
        return this.complaintRepository.save(complaint);
    }
}
