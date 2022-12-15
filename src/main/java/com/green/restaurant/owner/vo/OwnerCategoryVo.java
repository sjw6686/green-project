package com.green.restaurant.owner.vo;

public class OwnerCategoryVo {
	//fields
	private int category_idx;
	private String category_name;
	
	//constructor
	public OwnerCategoryVo() {}
	
	public OwnerCategoryVo(int category_idx, String category_name) {
		super();
		this.category_idx = category_idx;
		this.category_name = category_name;
	}

	//getter/setter
	public int getCategory_idx() {
		return category_idx;
	}

	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	//toString
	@Override
	public String toString() {
		return "OwnerCategoryVo [category_idx=" + category_idx + ", category_name=" + category_name + "]";
	}
	
}
