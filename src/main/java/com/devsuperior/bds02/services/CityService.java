package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import com.devsuperior.bds02.services.exceptions.NotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	@Transactional
	public List<CityDTO> findAll() {
		List<City> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public CityDTO insert(CityDTO dto) {
		City city = new City();
		city.setName(dto.getName());
		city = repository.save(city);
		return new CityDTO(city);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Id " + id +" não encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de Integridade");
		}
	}		
}
