package com.narayan.corps.martdbbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.narayan.corps.martdbbackend.dao.CategoryDao;
import com.narayan.corps.martdbbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDAOImplementation implements CategoryDao {

	private static List<Category> categories = new ArrayList<Category>();
	
	static {
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Romantic");
		category.setDescription("This is romantic category");
		category.setImageUrl("category1");
		category.setActive(true);
		
		categories.add(category);
		
		//adding second category
		category = new Category();
		category.setId(2);
		category.setName("Drama");
		category.setDescription("This is Drama Category");
		category.setImageUrl("category2");
		category.setActive(true);
		
		categories.add(category);
		
		//adding third category
		category = new Category();
		category.setId(3);
		category.setName("Crime");
		category.setDescription("All my crime stories");
		category.setImageUrl("category3");
		category.setActive(true);
		
		categories.add(category);
		
		//adding fourth category
		category = new Category();
		category.setId(4);
		category.setName("Horror");
		category.setDescription("Let us scare some people");
		category.setImageUrl("category4");
		category.setActive(true);
		
		categories.add(category); 
	}
	
	@Override
	public List<Category> list() {
		//return whole categories list
		return categories;
	}

	@Override
	public Category get(int id) {
		// returning category details based on specific id
		for (Category category : categories) {
			if(category.getId() == id)
			{
				return category;
			}
		}
		return null;
	}

}
