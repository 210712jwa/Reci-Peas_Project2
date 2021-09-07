package com.codekages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekages.dao.RecipeDao;
import com.codekages.dto.AddRecipeDTO;
import com.codekages.exception.BadParameterException;
import com.codekages.exception.RecipeNotFoundException;
import com.codekages.model.Recipe;

@Service
public class RecipeService {

	private RecipeDao recipeDao;

	@Autowired
	public RecipeService(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

	public Recipe addRecipe(AddRecipeDTO addRecipeDto) throws BadParameterException {
		if (addRecipeDto.getName().trim().equals("")) {
			throw new BadParameterException("You can not have a blank name for recipe");
		}

		if (addRecipeDto.getType().trim().equals("")) {
			throw new BadParameterException("You can not have a blank recipe type");
		}

		if (addRecipeDto.getDescription().trim().equals("")) {
			throw new BadParameterException("You can not have a blank description");
		}

		Recipe recipe = recipeDao.addRecipe(addRecipeDto);

		return recipe;
	}
	
	public List<Recipe> getAllRecipes() throws RecipeNotFoundException {
		List<Recipe> recipes = recipeDao.getAllRecipes();
		
		if (recipes.size() == 0) {
			throw new RecipeNotFoundException("No recipes were found in the system");
		}
		
		return recipes;
	}
	
}
