package com.alabado.lab7.service;

import com.alabado.lab7.entity.Customer;
import com.alabado.lab7.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Customer add(String name) {
        Customer c = new Customer();
        c.setName(name);
        return repo.save(c);
    }
}
