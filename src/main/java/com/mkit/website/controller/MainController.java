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
	public String index(HttpServletRequest request, HttpServletResponse response,String read_tag,String start) {
		System.out.println("read_tag: "+read_tag);
		System.out.println("start: "+start);
		List<Item> itemList  = itemsService.findByCategory("sports");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}

	
}
