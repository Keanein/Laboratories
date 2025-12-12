package com.alabado.lab7.service;

import com.alabado.lab7.entity.Customer;
import com.alabado.lab7.entity.Invoice;
import com.alabado.lab7.entity.Product;
import com.alabado.lab7.repository.CustomerRepository;
import com.alabado.lab7.repository.InvoiceRepository;
import com.alabado.lab7.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public InvoiceService(InvoiceRepository invoiceRepo, CustomerRepository customerRepo, ProductRepository productRepo) {
        this.invoiceRepo = invoiceRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public List<Invoice> getAll() {
        return invoiceRepo.findAll();
    }

    public Invoice getById(Long id) {
        return invoiceRepo.findById(id).orElse(null);
    }

    public Invoice add(Long customerId, List<Long> productIds) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        List<Product> products = productRepo.findAllById(productIds);

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setProducts(products);

        return invoiceRepo.save(invoice);
    }
}
