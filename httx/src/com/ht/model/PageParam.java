package com.ht.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PageParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3178808194660018932L;
	
	protected  Integer page=1; 
	protected Integer rows=30; 
	protected String sort; 
	protected String order;
	protected Integer offset;
	
	public PageParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
		
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getOffset() {
		if(rows!=null&&page!=null){
			offset=this.rows*(page-1);
		}
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	
}
