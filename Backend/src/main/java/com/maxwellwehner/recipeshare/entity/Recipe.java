package com.maxwellwehner.recipeshare.entity;

import javax.persistence.*;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	
	@Column(length = 1000)
	private String description;

	@Column(length = 1000)
	private String ingredients;

	@Column(length = 1000)
	private String instructions;

	@Column(length = 1000)
	private String imageUrl;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User userId;

	public Recipe() {

	}

	public Recipe(String title, String description, String imageURL, String ingredients, String instructions) {
		super();
		this.title = title;
		this.description = description;
		this.imageUrl = imageURL;
		this.instructions = instructions;
		this.ingredients = ingredients;
	}

	public Recipe(String title, String description, String imageURL, String ingredients, String instructions, Long id) {
		super();
		this.title = title;
		this.description = description;
		this.imageUrl = imageURL;
		this.instructions = instructions;
		this.ingredients = ingredients;
		this.id = id;
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

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", description=" + description + ", ingredients=" + ingredients
				+ ", instructions=" + instructions + ", imageUrl=" + imageUrl + ", userId=" + userId + "]";
	}
}
