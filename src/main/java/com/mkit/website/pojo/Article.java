package com.mkit.website.pojo;

public class Article {
	private String title;
	private String add_time;
	private String author;
	private String content;
	private String category;
	private String keywords;
	private String imgURL;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", add_time=" + add_time
				+ ", author=" + author + ", content=" + content + ", category="
				+ category + ", keywords=" + keywords + ", imgURL=" + imgURL
				+ "]";
	}
	
	
}
