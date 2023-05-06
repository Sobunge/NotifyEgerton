package com.notify.NotifyEgerton.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	@OneToMany(mappedBy = "university", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<User> users;
}
