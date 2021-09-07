package com.codekages.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codekages.dto.AddRecipeDTO;
import com.codekages.dto.MessageDTO;
import com.codekages.exception.BadParameterException;
import com.codekages.exception.RecipeNotFoundException;
import com.codekages.model.Recipe;
import com.codekages.service.RecipeService;

@RestController
@CrossOrigin("http://localhost:4200")
public class RecipeController { // THIS IS THE LAYER FOR THE MAPPINGS

	@Autowired
	public RecipeService recipeService;

	@PostMapping(path = "/recipe", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addRecipe(@RequestBody AddRecipeDTO addRecipeDTO) {

		try {
			Recipe recipe = recipeService.addRecipe(addRecipeDTO);

			return ResponseEntity.status(201).body(recipe);
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));

		}

	}
	
	@GetMapping(path = "/recipes")
	public ResponseEntity<Object> getAllrecipes() {
		try {
			
			List<Recipe> recipes = recipeService.getAllRecipes();
			
			return ResponseEntity.status(200).body(recipes);
		} catch(RecipeNotFoundException e) {
			return ResponseEntity.status(404).body(new MessageDTO(e.getMessage()));
		}
	}
	
	
}
