package com.firstproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
