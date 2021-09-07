package com.codekages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codekages.dto.AddListOfRecipeDTO;
import com.codekages.dto.ListOfRecipeDTO;
import com.codekages.dto.MessageDTO;
import com.codekages.exception.BadParameterException;
import com.codekages.exception.ListOfRecipeNotFoundException;
import com.codekages.model.ListOfRecipe;
import com.codekages.service.ListOfRecipeService;

@RestController
//@CrossOrigin("http://localhost:4200")
public class ListOfRecipeController {


	@Autowired
	private ListOfRecipeService ListOfRecipeService;

	@PostMapping(path = "/listofrecipe", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addListOfRecipe(@RequestBody AddListOfRecipeDTO addListOfRecipeDTO){
		
		try {
			
		ListOfRecipe listofrecipe = ListOfRecipeService.addListOfRecipe(addListOfRecipeDTO);
		
		return ResponseEntity.status(201).body(listofrecipe);
		
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));
		
		}
	}
	@GetMapping(path = "/listofrecipe", produces = "application/json")
	public ResponseEntity<Object> getAllListOfRecipe(){
		
		try {
			List<ListOfRecipe> listofrecipe = ListOfRecipeService.getAllListOfRecipe();
			return ResponseEntity.status(200).body(listofrecipe);
			
		
		}catch (ListOfRecipeNotFoundException e) {
			return ResponseEntity.status(404).body(new MessageDTO(e.getMessage()));
		}
	}
	

	@PatchMapping(path = "/listofrecipe/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> editListOfRecipe(@PathVariable("id") int id , @RequestBody ListOfRecipeDTO listofrecipeDto) {

		try {
			ListOfRecipe editedListOfRecipe = ListOfRecipeService.editListOfRecipe(id, listofrecipeDto);

			return ResponseEntity.status(200).body(editedListOfRecipe);
		} catch (BadParameterException e) {
			return ResponseEntity.status(400).body(new MessageDTO(e.getMessage()));

		}

	}

}
