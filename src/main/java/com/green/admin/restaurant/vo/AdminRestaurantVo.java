package com.green.admin.restaurant.vo;

import java.util.Date;
import java.util.List;

import com.green.admin.review.vo.AdminReviewVo;

public class AdminRestaurantVo {
	private int restaurant_idx;
	private String brand_name;
	private String address;
	private String brand_tel;
	private String introduce;
	private Date enroll_date;
	private int owner_idx;
	private int file_idx;
	private String category_name;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

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

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public int getOwner_idx() {
		return owner_idx;
	}

	public void setOwner_idx(int owner_idx) {
		this.owner_idx = owner_idx;
	}

	public int getFile_idx() {
		return file_idx;
	}

	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}

	public AdminRestaurantVo() {

	}

	@Override
	public String toString() {
		return "RestaurantVo [restaurant_idx=" + restaurant_idx + ", brand_name=" + brand_name + ", address=" + address
				+ ", brand_tel=" + brand_tel + ", introduce=" + introduce + ", enroll_date=" + enroll_date
				+ ", owner_idx=" + owner_idx + ", file_idx=" + file_idx + ", category_name=" + category_name + "]";
	}

	public AdminRestaurantVo(int restaurant_idx, String brand_name, String address, String brand_tel, String introduce,
			Date enroll_date, int owner_idx, int file_idx, String category_name) {
		super();
		this.restaurant_idx = restaurant_idx;
		this.brand_name = brand_name;
		this.address = address;
		this.brand_tel = brand_tel;
		this.introduce = introduce;
		this.enroll_date = enroll_date;
		this.owner_idx = owner_idx;
		this.file_idx = file_idx;
		this.category_name = category_name;
	}

	

	
}
