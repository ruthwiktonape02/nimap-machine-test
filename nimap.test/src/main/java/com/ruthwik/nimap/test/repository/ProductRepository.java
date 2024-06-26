package com.ruthwik.nimap.test.repository;



import com.ruthwik.nimap.test.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
