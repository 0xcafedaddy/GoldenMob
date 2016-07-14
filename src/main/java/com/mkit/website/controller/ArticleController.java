package com.mkit.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkit.website.pojo.Article;
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
	public String findArticleById(String uuid,HttpServletRequest request){
		System.out.println(uuid);
		Article article = articleService.findArticleById(uuid);
		request.getSession().setAttribute("article", article);
		return "article";
	}
	
	
}
