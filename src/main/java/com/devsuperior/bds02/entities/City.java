package com.devsuperior.bds02.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.bds02.dto.CityDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_city")
@NoArgsConstructor
public class City implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String name;
	
	@OneToMany(mappedBy = "city")
	@Getter
	private List<Event> events = new ArrayList<>();

	public City(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
