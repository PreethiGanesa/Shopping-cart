package com.pree.shoppingcart.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pree.shoppingcart.dao.CartDao;
import com.pree.shoppingcart.dao.CustomerDao;
import com.pree.shoppingcart.dto.Cart;
import com.pree.shoppingcart.dto.Customer;
import com.pree.shoppingcart.dto.Item;

@Controller
public class CartController {
	@Autowired
	CartDao dao;
	
	@Autowired
	CustomerDao custdao;
	
	@RequestMapping("/fetchitemsfromcart")
	public ModelAndView fetchItemsFromCart (HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");
		
		Customer customer = custdao.findCustomerById(c.getId());		
		Cart cart = customer.getCart();
		List<Item> items = cart.getItem();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemslist", items);
		mav.addObject("totalprice", cart.getTotalprice());
		mav.setViewName("displaycartitemstocustomer");
		
		return mav;
	
	}

}
