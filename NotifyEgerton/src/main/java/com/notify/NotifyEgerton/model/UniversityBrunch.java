package com.notify.NotifyEgerton.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private University university;

	@OneToMany(mappedBy = "universityBrunch", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<User> users;

}
