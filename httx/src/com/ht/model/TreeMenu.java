package com.ht.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeMenu {

	private int id;
	private String text;
	private String state;
	private Map<String,Object> attributes;
	private List<TreeMenu> children;
	private String iconCls;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<TreeMenu> getChildren() {
		return children;
	}
	public void setChildren(List<TreeMenu> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	public void addAttr(String key, Object value){
		if(null == attributes){
			attributes = new HashMap<String,Object>();
		}
		attributes.put(key, value);
	}
	
}
