package com.codekages.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codekages.dto.AddListOfRecipeDTO;
import com.codekages.dto.IngredientDTO;
import com.codekages.dto.ListOfRecipeDTO;
import com.codekages.model.Ingredient;
import com.codekages.model.ListOfRecipe;
@Repository
public class ListOfRecipeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public ListOfRecipe addListOfRecipe(AddListOfRecipeDTO addListOfRecipeDTO) {
		Session session = sessionFactory.getCurrentSession();

		ListOfRecipe newListOfRecipe = new ListOfRecipe(addListOfRecipeDTO.getListOfRecipe(), addListOfRecipeDTO.getNameOfRecipes());

		session.persist(newListOfRecipe);
		return newListOfRecipe;
	}

	@Transactional
	public List<ListOfRecipe> getAllListOfRecipe() {
		Session session = sessionFactory.getCurrentSession();

		List<ListOfRecipe> listofrecipe = session.createQuery("FROM ListOfRecipe").getResultList();
		return listofrecipe;

	}
	
	@Transactional
	public ListOfRecipe editListOfRecipe(int id, ListOfRecipeDTO listofrecipeDto) {
		Session session = sessionFactory.getCurrentSession();

		ListOfRecipe editedListOfRecipe = session.get(ListOfRecipe.class, id);
		editedListOfRecipe.setListofrecipe(listofrecipeDto.getListOfRecipe());
		editedListOfRecipe.setNameOfRecipes(listofrecipeDto.getNameOfRecipes());
//		editedListOfRecipe.setQuantity(session.get(Ingredient.class, id).getQuantity() + ingredientDto.getQuantity());
		session.saveOrUpdate(editedListOfRecipe);
		
		
		return editedListOfRecipe;
	}
}
