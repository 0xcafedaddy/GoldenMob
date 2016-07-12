package com.mkit.website.test;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

public class Test {
	

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	
	
	public void f1(){
		QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("catagory", "sport"));

		
		String documentId = "123456";
        //SampleEntity sampleEntity = new SampleEntity();
//        sampleEntity.setId(documentId);
//        sampleEntity.setMessage("some message");
        //IndexQuery indexQuery = new IndexQueryBuilder().withId(sampleEntity.getId()).withObject(sampleEntity).build();
//        IndexQuery indexQuery = new IndexQueryBuilder();
//        elasticsearchTemplate.
//		
		
	}

	
	public static void main(String[] args) {
		
//		String title = request.getParameter("title");
//		String uuid = request.getParameter("uuid");
//		String domain = request.getParameter("domain");
//		String size = request.getParameter("size");
//		String catagory = request.getParameter("catagory");
//		size=size == null?"10":size;
//		Integer isize = Integer.valueOf(size);
		
		
		String catagory = "sport";
		
	
		
	}
	

}
