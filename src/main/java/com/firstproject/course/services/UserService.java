package com.firstproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.firstproject.course.entities.User;
import com.firstproject.course.repositories.UserRepository;
import com.firstproject.course.services.exceptions.DatabaseException;
import com.firstproject.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> u = repository.findById(id);
		return u.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User u) {
		return repository.save(u);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User u) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, u);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User u) {
		entity.setName(u.getName());
		entity.setEmail(u.getEmail());
		entity.setPhone(u.getPhone());
	}
}
