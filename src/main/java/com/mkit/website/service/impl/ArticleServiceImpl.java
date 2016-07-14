package com.mkit.website.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import com.mkit.website.pojo.Article;
import com.mkit.website.service.ArticleService;
import com.mkit.website.util.TransToString;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource(name = "client")
	private Client client;

	@Override
	public Article findArticleById(String uuid) {
//		QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(
//				QueryBuilders.matchQuery("uuid", uuid));
		BoolQueryBuilder lastQuery = QueryBuilders.boolQuery().must(QueryBuilders.idsQuery().ids(uuid));

		SearchRequestBuilder searchRequestBuilder = client.prepareSearch("holga_index");
		searchRequestBuilder.setTypes("webpage");
		searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
		searchRequestBuilder.setExplain(true);

		searchRequestBuilder.setQuery(lastQuery);
		SearchResponse repsonse = searchRequestBuilder.execute().actionGet();
		SearchHits searchHits = repsonse.getHits();
		SearchHit[] hits = searchHits.getHits();
		
		
		Article article = new Article();
		for (int i = 0; i < hits.length; i++) {
			SearchHit hit = hits[i];
			Map<String, Object> hitSource = hit.getSource();
			@SuppressWarnings("rawtypes")
			Map content = (Map) hitSource.get("content");

			article.setTitle(TransToString.getString(hitSource.get("title")));
			article.setAuthor(TransToString.getString(hitSource.get("author")));
			article.setAdd_time((String) hitSource.get("add_time"));
			
			System.out.println("title:"+i+hitSource.get("title"));
			
			//获取文章内容
			article.setContent((String)content.get("tcontent"));
			
		}
		

		return article;
	}

}
