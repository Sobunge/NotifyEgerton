package com.notify.NotifyEgerton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Groups {

	@NotNull
	@Size(min=4, max=20)
	@Column(name="name")
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="community_id")
	private Long groupId;

	@NotNull
	@Column(name="icon")
	@Lob
	private byte[] icon;
	
	@NotNull
	@Size(min=6,max=8)
	@Column(name="privacy")
	private String privacy;
	
	@NotNull
	@Size(min=8,max=200)
	@Column(name="description")
	private String description;

	public Groups() {
		
	}
	
	public Groups(Groups group) {
		this.name = group.name;
		this.icon = group.icon;
		this.privacy = group.privacy;
		this.description = group.description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}