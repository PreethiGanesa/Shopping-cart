package com.pree.shoppingcart.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pree.shoppingcart.dao.CartDao;
import com.pree.shoppingcart.dao.CustomerDao;
import com.pree.shoppingcart.dao.OrdersDao;
import com.pree.shoppingcart.dao.ProductDao;
import com.pree.shoppingcart.dto.Cart;
import com.pree.shoppingcart.dto.Customer;
import com.pree.shoppingcart.dto.Item;
import com.pree.shoppingcart.dto.Orders;
import com.pree.shoppingcart.dto.Product;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersDao dao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	ProductDao pdao;//to reduce the item stock

	@Autowired
	CartDao cartdao;
	
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder()
	{
		Orders o=new Orders();
		ModelAndView mav=new ModelAndView();
		mav.addObject("ordersobj",o);
		mav.setViewName("ordersform");
		return mav;
		
	}
	
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o,HttpSession session)
	{
		Customer cus=(Customer) session.getAttribute("customerinfo");
		Customer customer=cdao.findCustomerById(cus.getId());
		Cart cart=customer.getCart();
		
		List<Item> items=cart.getItem();
		
		List<Item> itemslist=new ArrayList<>();
		List<Item> itemswithgreaterquantity=new ArrayList<>();
		for(Item i:items)
		{
			Product p=pdao.findProductById(i.getProduct_id());
			if(i.getQuantity() < p.getStock())
			{
				itemslist.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				//reduce the stock
				pdao.updateProduct(p);
			}
			else
			{
				itemswithgreaterquantity.add(i);
			}
		}
		o.setItem(itemslist);
		
		double totalpriceoforder=0;
		for(Item i:itemslist)
		{
			totalpriceoforder=totalpriceoforder+i.getPrice();
		}
		
		o.setTotalprice(totalpriceoforder);
		
		cart.setItem(itemswithgreaterquantity);
		
		double totalPrice=0;
		for(Item i:itemswithgreaterquantity)
		{
			totalPrice=totalPrice+i.getPrice();
		}
		
		cart.setTotalprice(totalPrice);
		
		List<Orders> orders=customer.getOrders();
		if(orders.size()>0)
		{
			orders.add(o);
			customer.setOrders(orders);
		}
		else
		{
			List<Orders> orders1=new ArrayList<>();
			orders1.add(o);
			customer.setOrders(orders1);
		}
		
		customer.setCart(cart);
		cartdao.updateCart(cart);
		dao.saveOrders(o);
		cdao.updateCustomer(customer);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","order placed successfully");
		mav.addObject("orderdetails",o);
		mav.setViewName("customerBill");
		return mav;
		
	}
}
