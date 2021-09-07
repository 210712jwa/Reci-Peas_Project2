package com.codekages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekages.dao.ListOfRecipeDAO;
import com.codekages.dto.AddListOfRecipeDTO;
import com.codekages.dto.ListOfRecipeDTO;
import com.codekages.exception.BadParameterException;
import com.codekages.exception.ListOfRecipeNotFoundException;
import com.codekages.model.Ingredient;
import com.codekages.model.ListOfRecipe;

@Service
public class ListOfRecipeService {

	private ListOfRecipeDAO listofrecipeDAO;
	
	@Autowired 
	public ListOfRecipeService(ListOfRecipeDAO listofrecipeDAO) {
		this.listofrecipeDAO = listofrecipeDAO;
	}
	
	public ListOfRecipe addListOfRecipe(AddListOfRecipeDTO addListOfRecipeDTO) throws BadParameterException {
		if(addListOfRecipeDTO.getListOfRecipe().trim().equals("")) {
			throw new BadParameterException("You cannot have a blank name for the Recipe");
		}
		
		ListOfRecipe listofrecipe = listofrecipeDAO.addListOfRecipe(addListOfRecipeDTO);
		return listofrecipe;
	}
	public List<ListOfRecipe>getAllListOfRecipe() throws ListOfRecipeNotFoundException{
	List<ListOfRecipe>listofrecipe =  listofrecipeDAO.getAllListOfRecipe();
	
	if (listofrecipe.size()==0) {
		throw new ListOfRecipeNotFoundException("No List of Recipes were found in the system");
	}
	return listofrecipe;
	}
	
	
	public ListOfRecipe editListOfRecipe(int id, ListOfRecipeDTO listOfRecipeDto) throws BadParameterException {
		//Session session = sessionFactory.getCurrentSession();
//		Ingredient editedIngredient = session.get(Ingredient.class, id);
		
//		if(ingredientDto.getQuantity() < 0) {
//			throw new BadParameterException("You can not have a negative quantity for ingredients");
//		}
//		
//		if (ingredientDto.getCost() < 0) {
//			throw new BadParameterException("You can not have a negative cost for ingredients");
//		}
		
		ListOfRecipe listofrecipe = listofrecipeDAO.editListOfRecipe(id, listOfRecipeDto);
		
		return listofrecipe;
	}
}
