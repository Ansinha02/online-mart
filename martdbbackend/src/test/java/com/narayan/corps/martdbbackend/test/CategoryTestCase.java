package com.narayan.corps.martdbbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.narayan.corps.martdbbackend.dao.CategoryDao;
import com.narayan.corps.martdbbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDao;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.narayan.corps.martdbbackend");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	@Test
	public void testCategoryCRUD()
	{
	
		//insertion testing
		
		category = new Category();		
		category.setName("Romantic");
		category.setDescription("The Perfect place for some romance with the Books");
		category.setImageUrl("category1.png");		
		assertEquals("Successfully added a category inside the table", true,categoryDao.add(category));
		
		category = new Category();		
		category.setName("Drama");
		category.setDescription("Books can also show some drama");
		category.setImageUrl("category2.png");		
		assertEquals("Successfully added a category inside the table", true,categoryDao.add(category));
		
		category = new Category();		
		category.setName("Crime");
		category.setDescription("Wanna play detective for sometime??? This is the place for you!");
		category.setImageUrl("category3.png");		
		assertEquals("Successfully added a category inside the table", true,categoryDao.add(category));
		
		category = new Category();		
		category.setName("Horror");
		category.setDescription("You think you can't get scared!!! Sneak a peek here once...");
		category.setImageUrl("category4.png");
		assertEquals("Successfully added a category inside the table", true,categoryDao.add(category));
		
		//fetching and update testing
		
		category = categoryDao.get(3);		
		category.setDescription("So you think you have seen all the drama??? Try us!");
		assertEquals("Successfully updated a specific category inside the table", true,categoryDao.update(category));
		
		//deletion testing
		//deleting the third row
		assertEquals("Successfully deleted a specific category from the table", true,categoryDao.delete(category));
		
		//list method testing
		assertEquals("Successfully fetched the categories from the table",3,categoryDao.list().size());
	
	}
	
}
