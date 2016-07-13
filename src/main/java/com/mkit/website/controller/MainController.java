package com.mkit.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkit.website.pojo.Item;
import com.mkit.website.service.ItemsService;


@Controller
public class MainController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(value = {"/", "/index", "index.html", "index.html", "index.jsp"}, method = RequestMethod.GET) 
	public String index(HttpServletRequest request, HttpServletResponse response,String read_tag,Integer start) {
		System.out.println("read_tag: "+read_tag);
		System.out.println("start: "+start);
		
		if( read_tag == null || start == null){
			//read_tag = "car";
			start = 0;
		}
		
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"sports"}, method = RequestMethod.GET) 
	public String sports(HttpServletRequest request, HttpServletResponse response,Integer start){
		System.out.println("sports");
		if(start == null){
			start = 0;
		}
		String read_tag = "sports";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
	@RequestMapping(value = {"health"}, method = RequestMethod.GET) 
	public String health(HttpServletRequest request, HttpServletResponse response,Integer start){
		System.out.println("health");
		if(start == null){
			start = 0;
		}
		String read_tag = "health";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
	@RequestMapping(value = {"life"}, method = RequestMethod.GET) 
	public String life(HttpServletRequest request, HttpServletResponse response,Integer start){
		System.out.println("life");
		if(start == null){
			start = 0;
		}
		String read_tag = "life";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"fun"}, method = RequestMethod.GET) 
	public String fun(HttpServletRequest request, HttpServletResponse response,Integer start){
		System.out.println("fun");
		if(start == null){
			start = 0;
		}
		String read_tag = "fun";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}

	@RequestMapping(value = {"tech"}, method = RequestMethod.GET) 
	public String tech(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "tech";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
}
