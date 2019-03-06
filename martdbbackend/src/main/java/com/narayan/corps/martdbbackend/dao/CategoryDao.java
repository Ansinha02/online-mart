package com.narayan.corps.martdbbackend.dao;

import java.util.List;

import com.narayan.corps.martdbbackend.dto.Category;

public interface CategoryDao {
	
	List<Category>list();

	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
}
