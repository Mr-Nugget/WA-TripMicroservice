package com.wildadventure.trip.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wildadventure.trip.exceptions.CategoryNotFoundException;
import com.wildadventure.trip.models.Category;
import com.wildadventure.trip.services.ICategoryService;

@RestController
@RequestMapping("/Category")
public class CategoryController {

	private static Logger log = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private ICategoryService categoryService;
	
	
	/**
	 * Get all categories in database
	 * @return a list of all trip categories
	 */
	@GetMapping(value = "/all")
	public List<Category> findAllCategories(){
		List<Category> allCategories = categoryService.getAll();
		return allCategories;
	}
	
	/**
	 * Get a category by its Id
	 * @param id
	 * @return error : 404, success : 200 with Category object
	 * @throws CategoryNotFoundException 
	 */
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable int id) throws CategoryNotFoundException {
		Long longId = new Long(id);
		
		Optional<Category> option = categoryService.getById(longId);
		
		if(option.isPresent()) {
			log.info("Find trip with id : " + id);
			return ResponseEntity.ok(option.get());
		}else {
			throw new CategoryNotFoundException("Cannot find category with id : " + id);
		}
		
	}
	
	/**
	 * Add a new category in Database
	 * @param category
	 * @return responseEntity with status code for clients : error = 404, success = 201
	 */
	@PostMapping(value = "/add")
	public ResponseEntity<Void> addCategory(@RequestBody Category category) {
		Category categoryAdded = categoryService.add(category);
		
		if(categoryAdded == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(categoryAdded.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
