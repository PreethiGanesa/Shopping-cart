package com.pree.shoppingcart.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pree.shoppingcart.dto.Item;
import com.pree.shoppingcart.dto.Orders;

@Repository
public class OrdersDao {
	
	@Autowired
	EntityManagerFactory emf;
	

	   public void saveOrders(Orders o) {
		   EntityManager em=emf.createEntityManager();
		   EntityTransaction et=em.getTransaction();
		   
		   et.begin();
		   em.persist(o);
		   et.commit();
	   }
	   
	   
	   public void updateOrders(Orders  o) {
		   EntityManager em=emf.createEntityManager();
		   EntityTransaction et=em.getTransaction();
		   
		   et.begin();
		   em.merge(o);
		   et.commit();
	   }
	   public void deleteItemById(int id)
	   {
		   EntityManager em=emf.createEntityManager();
		   EntityTransaction et=em.getTransaction();
		   
		   Orders o=em.find(Orders.class, id);
		   et.begin();
		   em.remove(o);
		   et.commit();
	   }
	   public Orders findOrdersById(int id) {
		   EntityManager em=emf.createEntityManager();
		   Orders o=em.find(Orders.class,id);
		   if(o!=null)
			   return o;
		   else
			   return null;
	   }
	   public List<Orders> fetchAllOrders(){
		   EntityManager em=emf.createEntityManager();
		Query query  = em.createQuery("select o from Item o");
		return query.getResultList();
	   }



}
