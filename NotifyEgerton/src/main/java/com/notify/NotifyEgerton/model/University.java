package com.notify.NotifyEgerton.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class University {

	
	private String name;
	
	@Id
	private String id;
	private String description;
	private String icon;
		
}
