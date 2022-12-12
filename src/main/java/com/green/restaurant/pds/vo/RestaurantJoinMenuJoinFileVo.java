package com.green.restaurant.pds.vo;

public class RestaurantJoinMenuJoinFileVo {
	//fields
	//restaurant
	private int restaurant_idx;
	private String brand_name;
	private String address;
	private String brand_tel;
	private String introduce;
	private String enroll_date;
	private int owner_idx;
	private String category_name;
	private int table_type;
	//menu
	private int menu_idx;
	private String menu_name;
	private String menu_price;
	//img_file
	private int file_idx;
	private String file_name;
	private String file_ext;
	private String sfile_name;
	private int table_idx;
	
	//constructor
	public RestaurantJoinMenuJoinFileVo() {}
	public RestaurantJoinMenuJoinFileVo(int restaurant_idx, String brand_name, String address, String brand_tel,
			String introduce, String enroll_date, int owner_idx, String category_name, int table_type, int menu_idx,
			String menu_name, String menu_price, int file_idx, String file_name, String file_ext, String sfile_name,
			int table_idx) {
		super();
		this.restaurant_idx = restaurant_idx;
		this.brand_name = brand_name;
		this.address = address;
		this.brand_tel = brand_tel;
		this.introduce = introduce;
		this.enroll_date = enroll_date;
		this.owner_idx = owner_idx;
		this.category_name = category_name;
		this.table_type = table_type;
		this.menu_idx = menu_idx;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.file_idx = file_idx;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
		this.table_idx = table_idx;
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
	public int getTable_type() {
		return table_type;
	}
	public void setTable_type(int table_type) {
		this.table_type = table_type;
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
	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getSfile_name() {
		return sfile_name;
	}
	public void setSfile_name(String sfile_name) {
		this.sfile_name = sfile_name;
	}
	public int getTable_idx() {
		return table_idx;
	}
	public void setTable_idx(int table_idx) {
		this.table_idx = table_idx;
	}
	
	//toString
	@Override
	public String toString() {
		return "RestaurantJoinMenuJoinFileVo [restaurant_idx=" + restaurant_idx + ", brand_name=" + brand_name
				+ ", address=" + address + ", brand_tel=" + brand_tel + ", introduce=" + introduce + ", enroll_date="
				+ enroll_date + ", owner_idx=" + owner_idx + ", category_name=" + category_name + ", table_type="
				+ table_type + ", menu_idx=" + menu_idx + ", menu_name=" + menu_name + ", menu_price=" + menu_price
				+ ", file_idx=" + file_idx + ", file_name=" + file_name + ", file_ext=" + file_ext + ", sfile_name="
				+ sfile_name + ", table_idx=" + table_idx + "]";
	}
}
