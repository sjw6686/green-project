package com.green.restaurant.owner.vo;

public class RestaurantMenuFileBoardCommentJoinVo {
	//restaurant
	private int restaurant_idx;
	private String brand_name;
	private String address;
	private String brand_tel;
	private String introduce;
	private String enroll_date;
	private int owner_idx;
	private String category_name;
	//menu
	private int menu_idx;
	private String menu_name;
	private String menu_price;
	//file
	private int file_idx;
	private int table_type;
	private String file_name;
	private String file_ext;
	private String sfile_name;
	private int table_idx;
	//board
	private int board_idx;
	private int board_type;
	private String board_title;
	private String board_content;
	private int review_avg;
	private String reg_date;
	private int view_cnt;
	private String user_id;
	private int cnt_like;
	private int cnt_hate;
	//comment
	private int comment_idx;
	private String comment_content;
	private int lvl;
	private int step;
	private int cnum;
	private int nref;
	
	//constructor
	public RestaurantMenuFileBoardCommentJoinVo() {}
	
	public RestaurantMenuFileBoardCommentJoinVo(int restaurant_idx, String brand_name, String address, String brand_tel,
			String introduce, String enroll_date, int owner_idx, String category_name, int menu_idx, String menu_name,
			String menu_price, int file_idx, int table_type, String file_name, String file_ext, String sfile_name,
			int table_idx, int board_idx, int board_type, String board_title, String board_content, int review_avg,
			String reg_date, int view_cnt, String user_id, int cnt_like, int cnt_hate, int comment_idx,
			String comment_content, int lvl, int step, int cnum, int nref) {
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
		this.file_idx = file_idx;
		this.table_type = table_type;
		this.file_name = file_name;
		this.file_ext = file_ext;
		this.sfile_name = sfile_name;
		this.table_idx = table_idx;
		this.board_idx = board_idx;
		this.board_type = board_type;
		this.board_title = board_title;
		this.board_content = board_content;
		this.review_avg = review_avg;
		this.reg_date = reg_date;
		this.view_cnt = view_cnt;
		this.user_id = user_id;
		this.cnt_like = cnt_like;
		this.cnt_hate = cnt_hate;
		this.comment_idx = comment_idx;
		this.comment_content = comment_content;
		this.lvl = lvl;
		this.step = step;
		this.cnum = cnum;
		this.nref = nref;
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
	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}
	public int getTable_type() {
		return table_type;
	}
	public void setTable_type(int table_type) {
		this.table_type = table_type;
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
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getBoard_type() {
		return board_type;
	}
	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getReview_avg() {
		return review_avg;
	}
	public void setReview_avg(int review_avg) {
		this.review_avg = review_avg;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getCnt_like() {
		return cnt_like;
	}
	public void setCnt_like(int cnt_like) {
		this.cnt_like = cnt_like;
	}
	public int getCnt_hate() {
		return cnt_hate;
	}
	public void setCnt_hate(int cnt_hate) {
		this.cnt_hate = cnt_hate;
	}
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getNref() {
		return nref;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}

	//toString
	@Override
	public String toString() {
		return "RestaurantMenuFileBoardCommentJoinVo [restaurant_idx=" + restaurant_idx + ", brand_name=" + brand_name
				+ ", address=" + address + ", brand_tel=" + brand_tel + ", introduce=" + introduce + ", enroll_date="
				+ enroll_date + ", owner_idx=" + owner_idx + ", category_name=" + category_name + ", menu_idx="
				+ menu_idx + ", menu_name=" + menu_name + ", menu_price=" + menu_price + ", file_idx=" + file_idx
				+ ", table_type=" + table_type + ", file_name=" + file_name + ", file_ext=" + file_ext + ", sfile_name="
				+ sfile_name + ", table_idx=" + table_idx + ", board_idx=" + board_idx + ", board_type=" + board_type
				+ ", board_title=" + board_title + ", board_content=" + board_content + ", review_avg=" + review_avg
				+ ", reg_date=" + reg_date + ", view_cnt=" + view_cnt + ", user_id=" + user_id + ", cnt_like="
				+ cnt_like + ", cnt_hate=" + cnt_hate + ", comment_idx=" + comment_idx + ", comment_content="
				+ comment_content + ", lvl=" + lvl + ", step=" + step + ", cnum=" + cnum + ", nref=" + nref + "]";
	}
	
}
