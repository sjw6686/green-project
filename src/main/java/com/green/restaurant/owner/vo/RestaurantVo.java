package com.green.restaurant.owner.vo;

public class RestaurantVo {
	private int restaurantIdx;
	private String brandName;
	private String address;
	private String brandTel;
	private String introduce;
	private String enrollDate;
	private int ownerIdx;
	private String categoryName;
	private int tableType;
	
	//constructor
	public RestaurantVo() {}
	
	public RestaurantVo(int restaurantIdx, String brandName, String address, String brandTel, String introduce,
			String enrollDate, int ownerIdx, String categoryName, int tableType) {
		super();
		this.restaurantIdx = restaurantIdx;
		this.brandName = brandName;
		this.address = address;
		this.brandTel = brandTel;
		this.introduce = introduce;
		this.enrollDate = enrollDate;
		this.ownerIdx = ownerIdx;
		this.categoryName = categoryName;
		this.tableType = tableType;
	}

	//getter/setter
	public int getRestaurantIdx() {
		return restaurantIdx;
	}

	public void setRestaurantIdx(int restaurantIdx) {
		this.restaurantIdx = restaurantIdx;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrandTel() {
		return brandTel;
	}

	public void setBrandTel(String brandTel) {
		this.brandTel = brandTel;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getOwnerIdx() {
		return ownerIdx;
	}

	public void setOwnerIdx(int ownerIdx) {
		this.ownerIdx = ownerIdx;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	//toString
	@Override
	public String toString() {
		return "RestaurantVo [restaurantIdx=" + restaurantIdx + ", brandName=" + brandName + ", address=" + address
				+ ", brandTel=" + brandTel + ", introduce=" + introduce + ", enrollDate=" + enrollDate + ", ownerIdx="
				+ ownerIdx + ", categoryName=" + categoryName + ", table_type=" + tableType + "]";
	}
	
}
