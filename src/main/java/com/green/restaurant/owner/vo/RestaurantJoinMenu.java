package com.green.restaurant.owner.vo;

public class RestaurantJoinMenu {
	private int restaurant_idx;
	private String brand_name;
	private String address;
	private String brand_tel;
	private String introduce;
	private String enroll_date;
	private int owner_idx;
	private String category_name;
	private int menu_idx;
	private String menu_name;
	private String menu_price;
	
	//constructor
	public RestaurantJoinMenu() {}
	
	public RestaurantJoinMenu(int restaurant_idx, String brand_name, String address, String brand_tel, String introduce,
			String enroll_date, int owner_idx, String category_name, int menu_idx, String menu_name,
			String menu_price) {
		super();
		this.restaurant_idx = restaurant_idx;
		this.brand_name = brand_name;
		this.address = address;
		this.brand_tel = brand_tel;
		this.introduce = introduce;
		this.enroll_date = enroll_date;
		this.owner_idx = owner_idx;
		this.category_name = category_name;
		this.menu_idx = menu_idx;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}
	
	//getter/setter
	public int getRestaurant_idx() {
		return restaurant_idx;
	}
	public void setRestaurant_idx(int restaurant_idx) {
		this.restaurant_idx = restaurant_idx;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrand_tel() {
		return brand_tel;
	}
	public void setBrand_tel(String brand_tel) {
		this.brand_tel = brand_tel;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public int getOwner_idx() {
		return owner_idx;
	}
	public void setOwner_idx(int owner_idx) {
		this.owner_idx = owner_idx;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getMenu_idx() {
		return menu_idx;
	}
	public void setMenu_idx(int menu_idx) {
		this.menu_idx = menu_idx;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}
	
	//toString
	@Override
	public String toString() {
		return "RestaurantJoinMenu [restaurant_idx=" + restaurant_idx + ", brand_name=" + brand_name + ", address="
				+ address + ", brand_tel=" + brand_tel + ", introduce=" + introduce + ", enroll_date=" + enroll_date
				+ ", owner_idx=" + owner_idx + ", category_name=" + category_name + ", menu_idx=" + menu_idx
				+ ", menu_name=" + menu_name + ", menu_price=" + menu_price + "]";
	}
}
