package com.mkit.website.service;

import com.mkit.website.pojo.Article;

/**
 * 查询文章
 * @author yang
 *
 */
public interface ArticleService {

	/**
	 * 根据uuid查询文章
	 * @return
	 */
	public Article findArticleById(String uuid);
	
}
