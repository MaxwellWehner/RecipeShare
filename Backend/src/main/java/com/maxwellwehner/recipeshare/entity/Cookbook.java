package com.maxwellwehner.recipeshare.entity;

import javax.persistence.*;

@Entity
public class Cookbook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String description;

	private String imageUrl;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userId;

	public Cookbook() {

	}

	public Cookbook(String title, String description, String imageURL) {
		super();
		this.title = title;
		this.description = description;
		this.imageUrl = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cookbook [id=" + id + ", title=" + title + ", description=" + description + ", imageURL=" + imageUrl
				+ "]";
	}

}