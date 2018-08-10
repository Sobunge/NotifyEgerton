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
public class Community {

	@NotNull
	@Size(min=4, max=20)
	@Column(name="name")
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="community_id")
	private Long communityId;

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
	

	public Community() {
		
	}
	
	public Community(Community community) {
		this.name = community.name;
		this.icon = community.icon;
		this.privacy = community.privacy;
		this.description = community.description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
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
