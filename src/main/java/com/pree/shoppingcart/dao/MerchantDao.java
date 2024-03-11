package com.pree.shoppingcart.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pree.shoppingcart.dto.Merchant;
import com.pree.shoppingcart.dto.Product;

@Repository
public class MerchantDao {

	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	ProductDao dao;
	
	public void saveMerchant(Merchant merchant)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(merchant);
		et.commit();
		
	}
	
	public Merchant login(String email,String password) {
	    EntityManager em=emf.createEntityManager();
	    Query query=em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");

	    query.setParameter(1,email);
	    query.setParameter(2,password);
	    try {
	    Merchant merchant=(Merchant) query.getSingleResult();
	    return merchant;
	    }
	    catch (NoResultException e) {
	    	return null;
	    }

		
	}

	public void updateMerchant(Merchant m)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(m);
		et.commit();
	}
	
	public Merchant findMerchantById(int id)
	{
		EntityManager em=emf.createEntityManager();
	
		
		Merchant mer=em.find(Merchant.class,id);
		
		if(mer!=null)
			return mer;
		else
			return null;
	}
	
	public Merchant deleteProductFromMerchant(int merchant_id,int product_id)
	{
		EntityManager em=emf.createEntityManager();
		
		Merchant merc=em.find(Merchant.class,merchant_id);
		List<Product> pro=merc.getProducts();
		
		List<Product> productsList=new ArrayList<>();
		
		//products.stream().filter(product->product.getId()!=product_id).collect(Collectors.toList());
		//convert list to stream nof product in list
		
		/*List<Product> productslist=new ArrayList();*/
		
		for(Product p:pro)
		{
			if(p.getId()!=product_id)
				productsList.add(p);
		}
		
		merc.setProducts(productsList);
		
		return merc;
		
	}

}
