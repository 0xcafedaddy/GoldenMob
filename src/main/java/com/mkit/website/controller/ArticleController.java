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
	
	
	@RequestMapping(value = "share", method = RequestMethod.GET)
	public String findArticleById(String id,String category,String keywords,String imie,HttpServletRequest request){
			Article article = articleService.findArticleById(id);
			
			if(article.getKeywords()!= null && article.getCategory() !=null ){
				List<Item> relatedItem = articleService.findRelatedItems(article.getKeywords(), article.getCategory());
				request.getSession().setAttribute("relatedItem", relatedItem);
			}
			request.getSession().setAttribute("article", article);
			return "article";
	}
	
	
}
