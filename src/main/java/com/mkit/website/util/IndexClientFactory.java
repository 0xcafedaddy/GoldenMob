/************************************************
@description:IndexClientFactory.java是用来....
@author:shishansong
@date:2016年5月6日 下午3:12:33
@version:1.0 
*************************************************/
package com.mkit.website.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.client.Client;


/**
 * 获得一个查询客户端
 * @author yang
 *
 */

public class IndexClientFactory {
	private static Client client;
	private IndexClientFactory(){
		
	}
	public synchronized static Client getClient() {
		if (client != null){
			return client;
		}
		//TODO 分页装配。topicSize就是每页的条数。
		//String host = "47.88.22.82";
		String host = "idx.goldenlauncher.com";
		int port = 9300;

        // 自定义集群结点名称
       // String clusterName = "elasticsearch_pudongping";
		Settings settings = Settings.settingsBuilder().put("node.client", true).put("cluster.name","holgaIndexCluster").put("discovery.initial_state_timeout","10s").put("client.transport.ping_timeout", "10s").put("client.transport.sniff", false).build();
    	//Client client = null;
        // 获取客户端
//        try {
//        	client = new TransportClient.Builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return client;
	}
	
	
	public static SearchRequestBuilder getSearchRequestBuilder() {
		Client client = IndexClientFactory.getClient();
		// 创建查询索引,参数productindex表示要查询的索引库为productindex
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("holga_index");
        // 设置查询索引类型,setTypes("productType1", "productType2","productType3");
        // 用来设定在多个类型中搜索
        searchRequestBuilder.setTypes("webpage");
        

        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN =
        // 扫描查询,无序
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        // 设置查询关键词
        //searchRequestBuilder.setQuery(QueryBuilders.simpleQueryStringQuery(value));
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
		return searchRequestBuilder;
	}
	public static MultiSearchRequestBuilder getMulitSearch() {
		if(client !=null){
			return client.prepareMultiSearch();
		}
		Client client = IndexClientFactory.getClient();
		return client.prepareMultiSearch();
	}
}
