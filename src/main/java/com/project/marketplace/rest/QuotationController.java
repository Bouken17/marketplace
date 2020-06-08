package com.project.marketplace.rest;


import com.google.gson.Gson;
import com.project.marketplace.entity.Quotation;
import com.project.marketplace.service.QuotationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
