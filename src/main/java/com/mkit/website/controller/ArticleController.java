package com.mkit.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping(value = "detial", method = RequestMethod.GET)
	public String findArticleById(String id,HttpServletRequest request){
			Article article = articleService.findArticleById(id);
			if(article.getKeywords()!= null && article.getCategory() !=null ){
				List<Item> relatedItem = articleService.findRelatedItems(article.getKeywords(), article.getCategory());
				request.getSession().setAttribute("relatedItem", relatedItem);
			}
			request.getSession().setAttribute("article", article);
			return "article";
	}
	
	@RequestMapping(value = "/share/{dir}/{uuid}/{deviceId}", method = RequestMethod.GET)
	public String findArticleByIdMobile(@PathVariable(value = "uuid")String uuid,@PathVariable(value = "dir")String dir,@PathVariable(value = "deviceId")String deviceId,HttpServletRequest request){
		Article article = articleService.findArticleById(uuid);
		if(article.getKeywords()!= null && article.getCategory() !=null ){
			List<Item> relatedItem = articleService.findRelatedItems(article.getKeywords(), article.getCategory());
			request.getSession().setAttribute("relatedItem", relatedItem);
		}
		request.getSession().setAttribute("article", article);
		if(articleService.findUserInfo(dir, uuid, deviceId)){
			articleService.addUserInfo(dir, uuid, deviceId);
		}
		return "article";
}
	
	
}
