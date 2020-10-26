package com.register.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.model.Street;
import com.register.service.IStreetService;

@RestController
@RequestMapping({"/street"})
public class StreetController {
	
    @Autowired
    private IStreetService streetService;
	
	@PostMapping
	public ResponseEntity<Street> create(@RequestBody Street street){
	 return	new ResponseEntity<Street>(streetService.insert(street), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return streetService.findById(id)
	           .map(record -> {
	        	   streetService.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Street> update(@PathVariable("id") long id,
	                                      @RequestBody Street street) {
	   return streetService.findById(id)
	           .map(record -> {
	               record.setStreetName(street.getStreetName());
	               record.setNumber(street.getNumber());
	               record.setCity(street.getCity());
	               record.setComplement(street.getComplement());
	               record.setNeighbourhood(street.getNeighbourhood());
	               record.setState(street.getState());
	               record.setCountry(street.getCountry());
	               Street updated = streetService.update(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
		
	  Optional<Street> lista = streetService.findById(id);
      return lista.map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
}
