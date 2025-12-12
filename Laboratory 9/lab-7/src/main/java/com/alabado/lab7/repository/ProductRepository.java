package com.alabado.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alabado.lab7.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
