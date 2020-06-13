package com.project.marketplace.rest;


import com.google.gson.Gson;
import com.project.marketplace.entity.Quotation;
import com.project.marketplace.service.QuotationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotation")
public class QuotationController {
    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }
    @PostMapping("/add")
    public Quotation addComplaint(@RequestParam("quotation") String message){
        Quotation quotation = new Gson().fromJson(message, Quotation.class);
        return this.quotationService.addQuotation(quotation);
    }

    @GetMapping("getAll")
    public List<Quotation> getAllComplaints() {
        return this.quotationService.getAllQuotations();
    }

    @GetMapping("get/{id}")
    public Quotation getQuotation(@PathVariable("id") long id) {
        return this.quotationService.getQuotation(id);
    }

    @GetMapping("getAllOf/{id}")
    public List<Quotation> getQuotationsOfProduct(@PathVariable("id") long id) {
        return this.quotationService.getQuotationOfProduct(id);
    }

}
