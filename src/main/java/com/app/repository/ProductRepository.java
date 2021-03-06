package com.app.repository;

import com.app.entity.Product;
import com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
