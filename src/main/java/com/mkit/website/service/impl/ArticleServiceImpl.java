package com.mkit.website.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.mkit.website.pojo.Item;
import com.mkit.website.service.ArticleService;
import com.mkit.website.util.JdbcUtil;
import com.mkit.website.util.TransToString;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource(name = "client")
	private Client client;
	
	
	/**
	 * 查询文章内容
	 */
	@Override
	public Article findArticleById(String id) {
		BoolQueryBuilder lastQuery = QueryBuilders.boolQuery().must(QueryBuilders.idsQuery().ids(id));

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
			//Date d = DateUtil.stringToDate((String)hitSource.get("add_time"), DateUtil.YYYYMMDD);
			//article.setAdd_time(DateUtil.format(d, DateUtil.YYYYMMDD));
			article.setCategory(TransToString.getString(hitSource.get("app_category")));
			article.setKeywords(TransToString.getString(hitSource.get("keywords")));
			//获取文章内容
			article.setContent((String)content.get("tcontent"));
			//设置文章首图片地址
			@SuppressWarnings("unchecked")
			List<Map<String, String>> imageList = (ArrayList<Map<String, String>>) content
					.get("image");
			if (imageList != null && imageList.size() != 0) {
				article.setImgURL(TransToString.getString(imageList.get(0).get(
						"url")));
			}
		}
		return article;
	}

	
	
	/**
	 * 查询相关内容
	 */
	@Override
	public List<Item> findRelatedItems(String keywords,String category) {
		
		List<Item> relatedItemsList = new ArrayList<Item>();
		
		//需要keywords
		//tid
		//category
		
		
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(keywords));
		QueryBuilder queryCategory = QueryBuilders.matchQuery("app_category", category);
		query =  QueryBuilders.boolQuery().must(query).must(queryCategory);
		
		SearchRequestBuilder searchRequestBuilder = client.prepareSearch("holga_index");
		searchRequestBuilder.setQuery(query).addSort(SortBuilders.fieldSort("add_time").order(SortOrder.DESC));
		
		SearchResponse response = searchRequestBuilder.setFrom(0).setSize(10).execute().actionGet();
		SearchHits searchHits = response.getHits();//得到总条数
		SearchHit[] hits = searchHits.getHits();
		
		for (int i = 0; i < hits.length; i++) {
			Item item = new Item();
			SearchHit hit = hits[i];
			Map<String, Object> hitSource = hit.getSource();
			@SuppressWarnings("rawtypes")
			Map content = (Map) hitSource.get("content");
			
			item.setTitle(TransToString.getString(hitSource.get("title")));
			item.setKeyWords(TransToString.getString(hitSource.get("keywords")));
			item.setCategory(TransToString.getString(hitSource.get("app_category")));
			item.setUuid((String) hitSource.get("uuid"));
			
			//如果imageList不为空取第一张图片
			@SuppressWarnings("unchecked")
			List<Map<String, String>> imageList = (ArrayList<Map<String, String>>) content
					.get("image");
			if (imageList != null && imageList.size() != 0) {
				item.setImgURL(TransToString.getString(imageList.get(0).get(
						"url")));
			}
			relatedItemsList.add(item);
		}
		
		return relatedItemsList;
	}



	@Override
	public int addUserInfo(String dir, String uuid, String deviceId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into masala_user(dir,uuid,deviceId) values(?,?,?)";
		
		try {
			conn =JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			// 根据传入的参数来完善这条SQL语句
			ps.setObject(1,dir);
			ps.setObject(2,uuid);
			ps.setObject(3,deviceId);
			// 执行这条SQL语句
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally{
			JdbcUtil.free(null, ps, conn);
		}
}



	@Override
	public boolean findUserInfo(String dir, String uuid, String deviceId) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "select dir,uuid,deviceId from masala_user where dir= ? and uuid = ? and deviceId = ?";
		boolean flag = false;
		try {
			conn =JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ResultSet rs = null;
			// 根据传入的参数来完善这条SQL语句
			ps.setObject(1,dir);
			ps.setObject(2,uuid);
			ps.setObject(3,deviceId);
			// 执行这条SQL语句
			rs = ps.executeQuery();
			
			if(rs.next()){
//				if(rs.getString("dir").equals(dir) && rs.getString("uuid").equals(uuid) && rs.getString("deviceId").equals(deviceId)){
					flag = false;
//				}else{
//					flag = true;
//				}
			}else{
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}finally{
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}

}
