package com.project.marketplace.rest;


import com.google.gson.Gson;
import com.project.marketplace.entity.Complaint;
import com.project.marketplace.entity.Product;
import com.project.marketplace.service.ComplaintService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {
    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }
    @PostMapping("/contactUs")
    public Complaint addComplaint(@RequestParam("message") String message,@RequestParam("objet") String objet
            ,@RequestParam("email") String email,@RequestParam("name") String name){
        Complaint complaint = new Complaint();
        complaint.setName(name);
        complaint.setEmail(email);
        complaint.setMessage(message);
        complaint.setObjet(objet);
        return this.complaintService.addComplaint(complaint);
    }

}
