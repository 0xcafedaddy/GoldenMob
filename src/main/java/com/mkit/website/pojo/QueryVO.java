package com.mkit.website.pojo;

import java.text.ParseException;
import java.util.Date;

import com.mkit.website.util.DateUtil;

public class QueryVO {
	
	private Date saleTimeStart; // 开始日期
	private Date saleTimeEnd; // 结束日期
	
	private String saleTimeStartstr;
	private String saleTimeEndstr;
	
	
	
	private String cateage;  //分类
	private String author;	//作者

	public String getCateage() {
		return cateage;
	}
	public void setCateage(String cateage) {
		this.cateage = cateage;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	public Date getSaleTimeStart() {
		return saleTimeStart;
	}
	public void setSaleTimeStart(Date saleTimeStart) {
		//this.saleTimeStart = saleTimeStart;
	}
	
	public Date getSaleTimeEnd() {
		return saleTimeEnd;
	}
	public void setSaleTimeEnd(Date saleTimeEnd) {
		//this.saleTimeEnd = saleTimeEnd;
	}
	
	
	public String getSaleTimeStartstr() {
		return saleTimeStartstr;
	}
	public void setSaleTimeStartstr(String saleTimeStartstr) {
		try {
			this.saleTimeStart = DateUtil.stringToDate(saleTimeStartstr, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.saleTimeStartstr = saleTimeStartstr;
	}
	public String getSaleTimeEndstr() {
		return saleTimeEndstr;
	}
	public void setSaleTimeEndstr(String saleTimeEndstr) {
		try {
			this.saleTimeEnd = DateUtil.stringToDate(saleTimeEndstr, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.saleTimeEndstr = saleTimeEndstr;
	}
	
	
	
	@Override
	public String toString() {
		return "QueryVO [saleTimeStart=" + saleTimeStart + ", saleTimeEnd="
				+ saleTimeEnd + ", saleTimeStartstr=" + saleTimeStartstr
				+ ", saleTimeEndstr=" + saleTimeEndstr + ", cateage=" + cateage
				+ ", author=" + author + "]";
	}
	
	
	
	
	
	
}
