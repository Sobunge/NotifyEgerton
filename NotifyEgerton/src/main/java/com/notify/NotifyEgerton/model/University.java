package com.notify.NotifyEgerton.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {

	
	private String name;
	
	@Id
	private String id;
	private String description;
	private String icon;
	
	
	
	public University() {
		
	}
	public University(String name, String id, String description, String icon) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
