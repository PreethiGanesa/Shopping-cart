package com.pree.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pree.shoppingcart.dto.Cart;
@Repository//component or service canbe used here
public class CartDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public void saveCart(Cart cart)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(cart);
		et.commit();
	}
	
	public void updateCart(Cart cart)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(cart);
		et.commit();
	}
	
	public Cart findItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
		Cart c=em.find(Cart.class, id);
		if(c!=null)
			return c;
		else 
			return null;
	}
	
	public void deleteItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Cart i=em.find(Cart.class,id);
		
		et.begin();
		em.persist(i);
		et.commit();
	}
	
	public Cart removeAllItemsFromCart(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Cart c=em.find(Cart.class,id);
		c.setItem(null);
		c.setTotalprice(0);
		
		et.begin();
		em.merge(c);
		et.commit();
		
		return c;
	}
	
	public void removeItemFromCartById(int cart_id,int item_id)
	{
		
	}


}
