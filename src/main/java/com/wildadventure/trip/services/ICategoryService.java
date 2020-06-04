package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import com.wildadventure.trip.models.Category;


/**
 * Service interface for Category Bean
 * @author Titouan
 *
 */
public interface ICategoryService {

	public List<Category> getAll();
	
	public Optional<Category> getById(Long id);
	
	public Category add(Category category);
}
