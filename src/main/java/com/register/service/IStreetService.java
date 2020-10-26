package com.register.service;

import java.util.List;
import java.util.Optional;

import com.register.model.Street;

public interface IStreetService {
 
	List<Street> findAll();
	Street insert(Street street);
	Street update(Street street);
	Optional<Street> findById(Long id);
	void deleteById(Long id);
	
	
}
