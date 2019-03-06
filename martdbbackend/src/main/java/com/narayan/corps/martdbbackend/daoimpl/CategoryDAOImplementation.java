package com.narayan.corps.martdbbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.narayan.corps.martdbbackend.dao.CategoryDao;
import com.narayan.corps.martdbbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDAOImplementation implements CategoryDao {

	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	@Override
	public List<Category> list() {
		String activeCategoryList = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(activeCategoryList);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/**
	 * Accessing specific category based on ID
	 */
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	/**
	 * for adding category to database table
	 */
	@Override
	public boolean add(Category category) {
		
		try {
			//ADD category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	

	/**
	 * Updating a specific category
	 */
	@Override
	public boolean update(Category category) {
		
		try {
			//ADD category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Deleting a specific category
	 */
		@Override
		public boolean delete(Category category) {
			
			category.setActive(false);
			
			try {
				//ADD category to the database table
				sessionFactory.getCurrentSession().update(category);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}

}
