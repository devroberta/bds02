package com.devsuperior.bds02.dto;

import java.io.Serializable;

import com.devsuperior.bds02.entities.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public CityDTO(City entity) {
		id = entity.getId();
		name = entity.getName();
	}
}
