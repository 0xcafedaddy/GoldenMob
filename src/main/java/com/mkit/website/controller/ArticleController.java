package com.mkit.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkit.website.pojo.Article;
import com.mkit.website.pojo.Item;
import com.mkit.website.service.ArticleService;

/**
 * 查询文章
 * @author yang
 *
 */
@Controller

public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	//525b75c5b7388c5fe13fd8fb0762e431
	//526d43eef3a717f74ed44474c3adb22c
	
	@RequestMapping(value = "a", method = RequestMethod.GET)
	public String findArticleById(String uuid,String category,String keywords,HttpServletRequest request){
		
		String userAgent = request.getHeader("user-agent");
		
//		if(userAgent.contains("iPhone") || userAgent.contains("Android") ){
//			//System.out.println("手机用户");
//			Article article = articleService.findArticleById(uuid);
//			List<Item> relatedItem = articleService.findRelatedItems(keywords, category);
//			request.getSession().setAttribute("article", article);
//			request.getSession().setAttribute("relatedItem", relatedItem);
//			return "phoneArticle";
//			
//		}else{
			//System.out.println("电脑用户");
			Article article = articleService.findArticleById(uuid);
			List<Item> relatedItem = articleService.findRelatedItems(keywords, category);
			request.getSession().setAttribute("article", article);
			request.getSession().setAttribute("relatedItem", relatedItem);
			return "article";
//		}
		
		
//		System.out.println("uuid:"+uuid);
//		System.out.println("category:"+category);
//		System.out.println("keywords:"+keywords);
		
	}
	
	
	
	
	
	
}
