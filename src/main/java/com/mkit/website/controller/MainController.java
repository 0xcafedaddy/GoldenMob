package com.mkit.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkit.website.pojo.Item;
import com.mkit.website.service.ItemsService;



@Controller
public class MainController {
	
	@Autowired
	private ItemsService itemsService;
	
	
	/**
	 * 下载app
	 * @return
	 */
	@RequestMapping(value = {"app"}, method = RequestMethod.GET)
	public String downloadApp(){
		return "app";
	}
	
	@RequestMapping(value = {"/", "/index", "index.html", "index.html", "index.jsp"}, method = RequestMethod.GET) 
	public String index(HttpServletRequest request, HttpServletResponse response,String read_tag,@RequestParam(value = "start", defaultValue = "0") Integer start) {
		
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "/");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
	@RequestMapping(value = {"ent"}, method = RequestMethod.GET) 
	public String ent(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "ent";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "ent");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"politic"}, method = RequestMethod.GET) 
	public String politic(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "politic";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "politic");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
	@RequestMapping(value = {"sports"}, method = RequestMethod.GET) 
	public String sports(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "sports";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "sports");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
	@RequestMapping(value = {"health"}, method = RequestMethod.GET) 
	public String health(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "health";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "health");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
	@RequestMapping(value = {"/life"}, method = RequestMethod.GET) 
	public String life(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "life";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "life");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"/fun"}, method = RequestMethod.GET) 
	public String fun(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "fun";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "fun");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}

	@RequestMapping(value = {"/tech"}, method = RequestMethod.GET) 
	public String tech(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "tech";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "tech");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"/arts"}, method = RequestMethod.GET) 
	public String arts(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "arts";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "arts");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"/culture"}, method = RequestMethod.GET) 
	public String culture(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "culture";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "culture");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"/business"}, method = RequestMethod.GET) 
	public String business(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "business";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "business");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"/fashion"}, method = RequestMethod.GET) 
	public String fashion(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "fashion";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "fashion");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	@RequestMapping(value = {"/motivation"}, method = RequestMethod.GET) 
	public String motivation(HttpServletRequest request, HttpServletResponse response,Integer start){
		if(start == null){
			start = 0;
		}
		String read_tag = "motivation";
		List<Item> itemList  = itemsService.findByCategory(read_tag,start);
		request.getSession().setAttribute("flag", "motivation");
		request.getSession().setAttribute("itemList", itemList);
		return "index";
	}
	
	
}
