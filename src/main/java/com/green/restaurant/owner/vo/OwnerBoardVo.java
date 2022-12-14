package com.green.restaurant.owner.vo;

public class OwnerBoardVo {
	//fields
	//board
	private int board_idx;
	private int board_type;
	private String board_title;
	private String board_content;
	private int review_avg;
	private String boardRegDate;
	private int restaurant_idx;
	private int view_cnt;
	private String boardWriter;
	private int cnt_like;
	private int cnt_hate;
	private String address;
	
	//constructor
	public OwnerBoardVo() {}
	
	public OwnerBoardVo(int board_idx, int board_type, String board_title, String board_content, int review_avg,
			String boardRegDate, int restaurant_idx, int view_cnt, String boardWriter, int cnt_like, int cnt_hate,
			String address) {
		super();
		this.board_idx = board_idx;
		this.board_type = board_type;
		this.board_title = board_title;
		this.board_content = board_content;
		this.review_avg = review_avg;
		this.boardRegDate = boardRegDate;
		this.restaurant_idx = restaurant_idx;
		this.view_cnt = view_cnt;
		this.boardWriter = boardWriter;
		this.cnt_like = cnt_like;
		this.cnt_hate = cnt_hate;
		this.address = address;
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

	public String getBoardRegDate() {
		return boardRegDate;
	}

	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
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

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
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
	
	//toString
	@Override
	public String toString() {
		return "OwnerBoardVo [board_idx=" + board_idx + ", board_type=" + board_type + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", review_avg=" + review_avg + ", boardRegDate=" + boardRegDate
				+ ", restaurant_idx=" + restaurant_idx + ", view_cnt=" + view_cnt + ", boardWriter=" + boardWriter
				+ ", cnt_like=" + cnt_like + ", cnt_hate=" + cnt_hate + ", address=" + address + "]";
	}
	
}
