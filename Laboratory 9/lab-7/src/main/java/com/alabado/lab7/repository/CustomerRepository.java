package com.alabado.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alabado.lab7.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
