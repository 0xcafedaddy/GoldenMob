package com.mkit.website.service;

import java.util.List;

import com.mkit.website.pojo.Item;


/**
 * Items的Service层
 * @author yang
 *
 */
public interface ItemsService {
	
	/**
	 * 查询Items
	 */
	public List<Item> findByCategory(String app_category);
	
}
