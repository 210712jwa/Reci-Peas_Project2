package com.codekages.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "List_Of_Recipes")
@Getter@Setter@NoArgsConstructor@EqualsAndHashCode@ToString
public class ListOfRecipe {

//	public String getListofrecipe() {
//		return listofrecipe;
//	}
//
//	public void setListofrecipe(String listofrecipe) {
//		this.listofrecipe = listofrecipe;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "list_of_recipes")
	private String listofrecipe;
	
	@Column(name = "name_of_recipes")
	private String nameOfRecipes;

	public ListOfRecipe(String listofrecipe, String nameOfRecipes) {
		super();
		this.listofrecipe = listofrecipe;
		this.nameOfRecipes = nameOfRecipes;
	}
	
//	@ManyToOne
//	@JoinColumn(name ="Recipe")
//	private Recipe ??;
//	
	
	

}
