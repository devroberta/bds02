package com.devsuperior.bds02.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.devsuperior.bds02.entities.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private LocalDate date;
	private String url;
	private Long cityId;

	public EventDTO(Event entity) {
		id = entity.getId();
		name = entity.getName();
		date = entity.getDate();
		url = entity.getUrl();
		cityId = entity.getCity().getId();
	}
}
