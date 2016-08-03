package com.mkit.website.pojo;

import java.util.List;

public class Items {
	private String atime;
	private String content;
	private String tid;
	private String title;
	private String img;
	private String domain;
	private String url;	
	private List<Imgs> imgs;
	
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Imgs> getImgs() {
		return imgs;
	}
	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
	}
	
	
	@Override
	public String toString() {
		return "Items [atime=" + atime + ", content=" + content + ", tid="
				+ tid + ", title=" + title + ", img=" + img + ", domain="
				+ domain + ", url=" + url + ", imgs=" + imgs + "]";
	}
	
	
	
}
