package com.mkit.website.pojo;

public class Content {
	private String image;

	private String tcontent;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	@Override
	public String toString() {
		return "Content [image=" + image + ", tcontent=" + tcontent + "]";
	}
	
	
	
}
