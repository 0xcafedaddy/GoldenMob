package com.mkit.website.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.mkit.website.pojo.Item;


/**
 * Items的DAO层接口
 * @author yang
 *
 */
public interface ItemsDao extends Repository<Item,String>{

	/**
	 * 根据类别查询
	 */
	List<Item> findByCategory(String app_category);
	
	
	
}
