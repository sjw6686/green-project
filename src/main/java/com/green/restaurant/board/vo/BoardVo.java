package com.green.restaurant.board.vo;

public class BoardVo {
	
	private   int         board_idx;
	private   int         board_type;
	private   String    board_title;
	private   String    board_content;
	private   int         review_avg;
	private   String    reg_date;
	private   int         restaurant_idx;
	private   int         view_cnt;
	private  String     user_id;
	private   int         cnt_like;
	private   int         cnt_hate;
	private String 	  address;
	private   int         table_type;
	
	//constructor
	public BoardVo() {}
	
	public BoardVo(int board_idx, int board_type, String board_title, String board_content, int review_avg,
			String reg_date, int restaurant_idx, int view_cnt, String user_id, int cnt_like, int cnt_hate,
			String address , int table_type) {
		super();
		this.board_idx = board_idx;
		this.board_type = board_type;
		this.board_title = board_title;
		this.board_content = board_content;
		this.review_avg = review_avg;
		this.reg_date = reg_date;
		this.restaurant_idx = restaurant_idx;
		this.view_cnt = view_cnt;
		this.user_id = user_id;
		this.cnt_like = cnt_like;
		this.cnt_hate = cnt_hate;
		this.address = address;
		this.table_type = table_type;
	}

	//getter/setter
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

	public int getRestaurant_idx() {
		return restaurant_idx;
	}

	public void setRestaurant_idx(int restaurant_idx) {
		this.restaurant_idx = restaurant_idx;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public int getTable_type() {
		return table_type;
	}
	public void setTable_type(int table_type) {
		this.table_type = table_type;
	}

	
	//toString
	@Override
	public String toString() {
		return "BoardVo [board_idx=" + board_idx + ", board_type=" + board_type + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", review_avg=" + review_avg + ", reg_date=" + reg_date
				+ ", restaurant_idx=" + restaurant_idx + ", view_cnt=" + view_cnt + ", user_id=" + user_id
				+ ", cnt_like=" + cnt_like + ", cnt_hate=" + cnt_hate + ", address=" + address + ", table_type="
				+ table_type + "]";
	}

	
	

}