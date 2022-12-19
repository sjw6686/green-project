package com.green.restaurant.owner.vo;

public class OwnerRestaurantJoinImgFileVo {
	//restaurant
	private int restaurant_idx;
	private String brand_name;
	private String address;
	private String brand_tel;
	private String introduce;
	private String enroll_date;
	private int owner_idx;
	private String category_name;
	private int restaurantTable;
	//file
	private int file_idx;
	private int fileTable;
	private String file_name;
	private String file_ext;
	private String sfile_name;
	private String table_idx;
	
	//constructor
	public OwnerRestaurantJoinImgFileVo() {}
	
	public OwnerRestaurantJoinImgFileVo(int restaurant_idx, String brand_name, String address, String brand_tel,
			String introduce, String enroll_date, int owner_idx, String category_name, int restaurantTable,
			int file_idx, int fileTable, String file_name, String file_ext, String sfile_name, String table_idx) {
		super();
		this.restaurant_idx = restaurant_idx;
		this.brand_name = brand_name;
		this.address = address;
		this.brand_tel = brand_tel;
		this.introduce = introduce;
		this.enroll_date = enroll_date;
		this.owner_idx = owner_idx;
		this.category_name = category_name;
		this.restaurantTable = restaurantTable;
		this.file_idx = file_idx;
		this.fileTable = fileTable;
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
	public int getRestaurantTable() {
		return restaurantTable;
	}
	public void setRestaurantTable(int restaurantTable) {
		this.restaurantTable = restaurantTable;
	}
	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}
	public int getFileTable() {
		return fileTable;
	}
	public void setFileTable(int fileTable) {
		this.fileTable = fileTable;
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
	public String getTable_idx() {
		return table_idx;
	}
	public void setTable_idx(String table_idx) {
		this.table_idx = table_idx;
	}
	
	//toString
	@Override
	public String toString() {
		return "OwnerRestaurantJoinImgFileVo [restaurant_idx=" + restaurant_idx + ", brand_name=" + brand_name
				+ ", address=" + address + ", brand_tel=" + brand_tel + ", introduce=" + introduce + ", enroll_date="
				+ enroll_date + ", owner_idx=" + owner_idx + ", category_name=" + category_name + ", restaurantTable="
				+ restaurantTable + ", file_idx=" + file_idx + ", fileTable=" + fileTable + ", file_name=" + file_name
				+ ", file_ext=" + file_ext + ", sfile_name=" + sfile_name + ", table_idx=" + table_idx + "]";
	}
		
}
