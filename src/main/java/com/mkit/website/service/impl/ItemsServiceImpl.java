package com.mkit.website.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import com.mkit.website.pojo.Item;
import com.mkit.website.service.ItemsService;
import com.mkit.website.util.TransToString;


@Service("itemsService")
public class ItemsServiceImpl implements ItemsService{

	@Resource(name = "client")
	private Client client;
	
	@Override
	public List<Item> findByCategory(String app_category,Integer start) {
		
		QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(
				QueryBuilders.matchQuery("app_category", app_category));

		SearchRequestBuilder searchRequestBuilder = client
				.prepareSearch("holga_index");
		searchRequestBuilder.setTypes("webpage");
		searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
		searchRequestBuilder.setExplain(true);
		if(app_category != null){
			searchRequestBuilder
			.setQuery(queryBuilder)
			.addSort(
					SortBuilders.fieldSort("add_time")
							.order(SortOrder.DESC)).setFrom(start).setSize(10);
		}else{
		searchRequestBuilder.addSort(
						SortBuilders.fieldSort("add_time")
								.order(SortOrder.DESC)).setFrom(start).setSize(10);
		}
		SearchResponse repsonse = searchRequestBuilder.execute().actionGet();
		SearchHits searchHits = repsonse.getHits();
		SearchHit[] hits = searchHits.getHits();

		List<Item> itemList = new ArrayList<Item>();

		for (int i = 0; i < hits.length; i++) {
			Item item = new Item();
			SearchHit hit = hits[i];
			Map<String, Object> hitSource = hit.getSource();
			@SuppressWarnings("rawtypes")
			Map content = (Map) hitSource.get("content");

			item.setTitle(TransToString.getString(hitSource.get("title")));
			item.setAuthor(TransToString.getString(hitSource.get("author")));
			item.setPostDate((String) hitSource.get("post_date"));

			// 如果imageList不为空取第一张图片
			@SuppressWarnings("unchecked")
			List<Map<String, String>> imageList = (ArrayList<Map<String, String>>) content
					.get("image");
			if (imageList != null && imageList.size() != 0) {
				item.setImgURL(TransToString.getString(imageList.get(0).get(
						"url")));
			}
			System.out.println(item);
			itemList.add(item);
		}
		
		return itemList;
	}

}
