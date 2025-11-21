package com.alabado.lab7.service;

import com.alabado.lab7.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private Long nextId = 4L;

    public ProductService() {
        products.put(1L, new Product(1L, "Laptop Pro", 59999.0));
        products.put(2L, new Product(2L, "Wireless Mouse", 799.0));
        products.put(3L, new Product(3L, "Keyboard", 1299.0));
    }

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public Product getById(Long id) {
        return products.get(id);
    }

    public Product create(Product p) {
        p.setId(nextId++);
        products.put(p.getId(), p);
        return p;
    }

    public Product update(Long id, Product p) {
        if (!products.containsKey(id)) return null;
        p.setId(id);
        products.put(id, p);
        return p;
    }

    public boolean delete(Long id) {
        return products.remove(id) != null;
    }
}
