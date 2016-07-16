package com.mkit.website.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBean {
	
	//配置文件工具类  
	static Client  client = null;
    //注入的ElasticSearch实例  
    @Bean(name = "client")  
    public synchronized static Client getESClient() throws UnknownHostException{  
    	if (client != null){
			return client;
		}
    	String host = "idx.goldenmob.com";
		int port = 9300;
    	Settings settings = Settings.settingsBuilder().put("node.client", true).put("cluster.name","holgaIndexCluster").put("discovery.initial_state_timeout","10s").put("client.transport.ping_timeout", "10s").put("client.transport.sniff", false).build();
    	  client = new TransportClient.Builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
    	return client;  
    }  

}
