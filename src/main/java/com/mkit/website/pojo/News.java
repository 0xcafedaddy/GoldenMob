package com.mkit.website.pojo;

import java.util.List;

public class News {
	
	private String index;
	private String icon;
	private String topic;
	private String describe;
	private List<Items> items;
	
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
	@Override
	public String toString() {
		return "News [index=" + index + ", icon=" + icon + ", topic=" + topic
				+ ", describe=" + describe + ", items=" + items + "]";
	}
	
	

}
