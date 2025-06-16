package com.firstproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

