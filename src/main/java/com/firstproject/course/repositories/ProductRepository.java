package com.firstproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
