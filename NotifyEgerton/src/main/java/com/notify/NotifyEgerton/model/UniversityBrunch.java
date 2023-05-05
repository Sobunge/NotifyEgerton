package com.notify.NotifyEgerton.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UniversityBrunch {

	private String name;
	private String description;
	private String location;
	
	@Id
	private String id;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private University university;
		
}
