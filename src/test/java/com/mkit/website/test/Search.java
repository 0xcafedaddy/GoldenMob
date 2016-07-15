package com.mkit.website.test;

import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

public class Search {
	
	
	private static SearchHit[] getHitForRelated(Integer size, String keywords,
			String[] includeFields, String[] excludeFields,
			List<String> excludeIdList,String category){
		SearchRequestBuilder searchRequestBuilder = getSearchRequestBuilder();
        QueryBuilder query =  null;
        if (excludeIdList!=null && excludeIdList.size()>0){
	        query = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(keywords)).mustNot(QueryBuilders.idsQuery().ids(excludeIdList));
        }else{
        	query = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(keywords));
        }
		QueryBuilder queryCategory = QueryBuilders.matchQuery("app_category", category);
		query =  QueryBuilders.boolQuery().must(query).must(queryCategory);
        searchRequestBuilder.setQuery(query).addSort(SortBuilders.fieldSort("add_time").order(SortOrder.DESC));
		
        System.out.println(searchRequestBuilder);
        SearchResponse response = searchRequestBuilder.setFetchSource(includeFields,excludeFields).setFrom(0).setSize(size).execute().actionGet();
        SearchHits searchHits = response.getHits();//得到总条数
		SearchHit[] hits = searchHits.getHits();
		return hits;
	}
	
	
	

}
