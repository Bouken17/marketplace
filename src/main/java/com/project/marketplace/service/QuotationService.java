package com.project.marketplace.service;

import com.project.marketplace.repository.QuotationRepository;
import org.springframework.stereotype.Service;


@Service
public class QuotationService {
    private final QuotationRepository quotationRepository;
//    private final ProductService productService;

    public QuotationService(QuotationRepository quotationRepository, ProductService productService) {
        this.quotationRepository = quotationRepository;
//        this.productService = productService;
//        this.initDB();
    }
//    private void initDB() {
//        Quotation quotation = new Quotation();
//        quotation.setEmail("Abdou@gmail.com");
//        quotation.setAddress("CIN1");
//        quotation.setFirstname("Laouali");
//        quotation.setLastname("Mahaboubou");
//        quotation.setProduct(productService.getAllProducts().get(0));
//        this.addQuotation(quotation);
//    }
//    public Quotation addQuotation(Quotation quotation) {
//        return this.quotationRepository.save(quotation);
//    }
}
