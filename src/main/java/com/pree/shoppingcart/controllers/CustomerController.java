package com.pree.shoppingcart.controllers;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pree.shoppingcart.dao.CustomerDao;
import com.pree.shoppingcart.dto.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao cdao;
	
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer()
	{
		Customer c=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj", c);
		mav.setViewName("customerform");
		
		return mav;
		
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute ("customerobj") Customer c)
	{
		cdao.saveCustomer(c);
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Registred successfully");
		mav.setViewName("customerloginform");
		
		return mav;
		
		
	}
	
	@RequestMapping("/customerloginvalidation")//these methods called as servlets
	public ModelAndView loginValidation(ServletRequest req,HttpSession session)
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Customer c=cdao.login(email, password);
		ModelAndView mav=new ModelAndView();
		
		if(c!=null)
		{
			mav.addObject("message","login successfull");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo", c);
			return mav;
		}
		else
		{
			mav.addObject("message","Invalid credenitals");
			mav.setViewName("customerloginform");
			return mav;
		}
		
	}
	


}
