package com.pree.shoppingcart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pree.shoppingcart.dto.Customer;
import com.pree.shoppingcart.dto.Item;
import com.pree.shoppingcart.dto.Product;

@Repository
public class ItemDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveItem(Item item)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(item);
		et.commit();
	}
	
	
	
	public void updateItem(Item i)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(i);
		et.commit();
	}
	
	
	public Item findItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
		Item i=em.find(Item.class, id);
		if(i!=null)
			return i;
		else 
			return null;
	}
	
	public void deleteItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Item i=em.find(Item.class,id);
		
		et.begin();
		em.persist(i);
		et.commit();
	}
	
	public List<Product> fetchAllItem()
	{
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select i from Item i");
		return query.getResultList();
	}
	

}
