package com.codekages.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// The letter 'r' that is in front of the variable stands for "recipe". 
// For Example: "rName" stand for recipeName.

@Entity
@Table(name = "Recipes")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString

public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rName")
	private String recipeName;

	@Column(name = "rType")
	private String recipeType;

	@Column(name = "rDescription")
	private String recipeDescription;

	@ManyToOne
	@JoinColumn(name = "ingredientId")
	private Ingredient ingredientId;

	public Recipe(String name, String type, String description) {
		super();
		this.recipeName = name;
		this.recipeType = type;
		this.recipeDescription = description;
	}

}
