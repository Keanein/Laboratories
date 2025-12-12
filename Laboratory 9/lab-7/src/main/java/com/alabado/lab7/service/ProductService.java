package com.alabado.lab7.service;

import com.alabado.lab7.entity.Product;
import com.alabado.lab7.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product add(String name) {
        Product p = new Product();
        p.setName(name);
        return repo.save(p);
    }
}