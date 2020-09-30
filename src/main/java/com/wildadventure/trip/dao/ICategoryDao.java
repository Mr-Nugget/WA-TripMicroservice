package com.wildadventure.trip.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.trip.models.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Long>{

	Optional<Category> findById(Long id);
}
