package com.green.restaurant.owner.vo;

public class RestaurantVo {
	private int restaurantIdx;
	private String brandName;
	private String address;
	private String brandTel;
	private String introduce;
	private String enrollDate;
	private int ownerIdx;
	private int fileIdx;
	
	//constructor
	public RestaurantVo() {};
	public RestaurantVo(int restaurantIdx, String brandName, String address, String brandTel, String introduce,
			String enrollDate, int ownerIdx, int fileIdx) {
		super();
		this.restaurantIdx = restaurantIdx;
		this.brandName = brandName;
		this.address = address;
		this.brandTel = brandTel;
		this.introduce = introduce;
		this.enrollDate = enrollDate;
		this.ownerIdx = ownerIdx;
		this.fileIdx = fileIdx;
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
	public int getFileIdx() {
		return fileIdx;
	}
	public void setFileIdx(int fileIdx) {
		this.fileIdx = fileIdx;
	}
	
	//toString
	@Override
	public String toString() {
		return "RestaurantVo [restaurantIdx=" + restaurantIdx + ", brandName=" + brandName + ", address=" + address
				+ ", brandTel=" + brandTel + ", introduce=" + introduce + ", enrollDate=" + enrollDate + ", ownerIdx="
				+ ownerIdx + ", fileIdx=" + fileIdx + "]";
	}
	
}
