package com.wildadventure.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.trip.dao.ICategoryDao;
import com.wildadventure.trip.models.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public List<Category> getAll() {
		return categoryDao.findAll();
	}

	@Override
	public Optional<Category> getById(Long id) {
		return categoryDao.findById(id);
	}

	@Override
	public Category add(Category category) {
		return categoryDao.save(category);
	}
	
	
}
