package com.mkit.website.service;

import java.util.List;

import com.mkit.website.pojo.Article;
import com.mkit.website.pojo.Item;

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
	
	/**
	 * 查询相关文章
	 * @return
	 */
	public List<Item> findRelatedItems(String keywords,String category);
	
	
	public int addUserInfo(String dir,String uuid,String deviceId);

	
	public boolean findUserInfo(String dir,String uuid,String deviceId);
	
	
	
}
