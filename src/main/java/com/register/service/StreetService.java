package com.register.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.register.common.Geocode;
import com.register.common.Location;
import com.register.model.Street;
import com.register.repository.StreetRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StreetService implements IStreetService{
   
	@Value("${uri.acess.geolocalizacao}")
	private String geolocalizacao;
	
	@Value("${uri.acess.key}")
	private String keyGeoLocalizacao;
	 
	@Autowired
    private StreetRepository repository;

	@Override
	public List<Street> findAll() {
		return repository.findAll();
	}

	@Override
	public Street insert(Street street) {
		if (Objects.isNull(street.getLatitude()) || Objects.isNull(street.getLongitude()) ||
		    street.getLatitude() == 0 || street.getLongitude() == 0) {
			Location localizacao =  getGeolocalizacao(street);
			street.setLatitude(localizacao.getLat());
			street.setLongitude(localizacao.getLng());
			return repository.save(street);
		}else {
			return repository.save(street);
		}
		
	}

	@Override
	public Street update(Street street) {
		return repository.saveAndFlush(street);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Street> findById(Long id) {
		return repository.findById(id);
	}
	
	/*
	 * Recupera a Localização Latitude e Longitude
	 */
	public Location getGeolocalizacao(Street street){
		// Monta parametros para URI da Geolocalização
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder query = new StringBuilder();
		query.append("?address=");
		query.append(street.getNumber()+"+"+street.getStreetName()+",");
		query.append(street.getCity()+"+"+street.getState()+",");
		query.append(street.getCountry());
		query.append("&");
		query.append("key="+keyGeoLocalizacao);
		String uri = geolocalizacao+query.toString();
		Geocode geocode = restTemplate.getForObject(uri, Geocode.class);

		return geocode.getResults().get(0).getGeometry().getLocation();
	}	

}
