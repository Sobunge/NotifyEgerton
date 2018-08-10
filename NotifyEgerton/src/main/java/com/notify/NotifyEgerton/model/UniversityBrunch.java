package com.notify.NotifyEgerton.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public UniversityBrunch(String name, String description, String location, String id, String universityId) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.id = id;
		this.university = new University("", universityId, "","");
	}

	
	public UniversityBrunch() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}
	
	
	
}
