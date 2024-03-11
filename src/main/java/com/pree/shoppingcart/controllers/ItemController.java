package com.pree.shoppingcart.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pree.shoppingcart.dao.CartDao;
import com.pree.shoppingcart.dao.CustomerDao;
import com.pree.shoppingcart.dao.ItemDao;
import com.pree.shoppingcart.dao.ProductDao;
import com.pree.shoppingcart.dto.Cart;
import com.pree.shoppingcart.dto.Customer;
import com.pree.shoppingcart.dto.Item;
import com.pree.shoppingcart.dto.Product;

@Controller
public class ItemController {
	
	@Autowired
	ItemDao dao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cdao;
	
	@Autowired
	CustomerDao cusdao;
	
	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id") int id)//used to fetch the data from the url requestpar is used
	{
		Product p=pdao.findProductById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("prodobj",p);
		mav.setViewName("itemform");
		return mav;
	}
	
	@RequestMapping("/additemtocart")
	public ModelAndView AddItemToCart(ServletRequest req,HttpSession session)
	{
		int pid=Integer.parseInt(req.getParameter("id"));
		String brand=req.getParameter("brand");
		String category=req.getParameter("category");
		String model=req.getParameter("model");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		Item item=new Item();
		item.setBrand(brand);
		item.setCategory(category);
		item.setModel(model);
		item.setQuantity(quantity);
		item.setProduct_id(pid);
		item.setPrice(quantity*price);
		
		Customer customer=(Customer)session.getAttribute("customerinfo");
		Cart c=customer.getCart();
		
		if(c==null) 
		{
			Cart cart=new Cart();
			
			List<Item> items=new ArrayList<>();
			items.add(item);
			
			cart.setItem(items);
			cart.setName(customer.getName());
			
			cart.setTotalprice(item.getPrice());
			
			customer.setCart(cart);
			
			dao.saveItem(item);
			cdao.saveCart(cart);
			
			cusdao.updateCustomer(customer);//updating the customer information the cart has been created for the customer
		}
		
		else 
		{
			List<Item> items=c.getItem();
			
			if(items.size()>0)
			{
				items.add(item);
				c.setItem(items);
				double totalprice=0;
				for(Item i:items) totalprice=totalprice+i.getPrice();
				c.setTotalprice(totalprice);
				
				dao.saveItem(item);
				cdao.updateCart(c);
				cusdao.updateCustomer(customer);
			}
			
			else 
			{
				List<Item> itemslist=new ArrayList<>();
				itemslist.add(item);
				c.setItem(itemslist);
				c.setTotalprice(item.getPrice());
				
				dao.saveItem(item);
				cdao.updateCart(c);
				cusdao.updateCustomer(customer);

			}	
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://displayproducts");
			
		return mav;
	}

}
