package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.model.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long>{};
     