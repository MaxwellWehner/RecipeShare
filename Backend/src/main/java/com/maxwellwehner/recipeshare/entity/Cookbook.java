package com.maxwellwehner.recipeshare.entity;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Cookbook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String description;

	@Column(length = 1000)
	private String imageUrl;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User userId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "recipes_cookbooks", joinColumns = @JoinColumn(name = "cookbook_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"))
	private Collection<Recipe> recipes;

	public Cookbook() {

	}

	public Cookbook(String title, String description, String imageURL) {
		super();
		this.title = title;
		this.description = description;
		this.imageUrl = imageURL;
	}
	
	public Cookbook(String title, String description, String imageURL, Long id) {
		super();
		this.title = title;
		this.description = description;
		this.imageUrl = imageURL;
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
	
	public Collection<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Collection<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Cookbook [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", userId=" + userId + ", recipes=" + recipes + "]";
	}
}
