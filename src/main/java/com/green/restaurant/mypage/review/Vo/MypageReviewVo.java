package com.green.restaurant.mypage.review.Vo;

public class MypageReviewVo {
	private String board_title;
	private String board_content;
	private int cnt_like;
	private int view_cnt;
	private int board_idx;
	private String user_id;
	public MypageReviewVo() {}
	public MypageReviewVo(String board_title, String board_content, int cnt_like, int view_cnt, int board_idx,
			String user_id) {
		super();
		this.board_title = board_title;
		this.board_content = board_content;
		this.cnt_like = cnt_like;
		this.view_cnt = view_cnt;
		this.board_idx = board_idx;
		this.user_id = user_id;
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
	public int getCnt_like() {
		return cnt_like;
	}
	public void setCnt_like(int cnt_like) {
		this.cnt_like = cnt_like;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "MypageReviewVo [board_title=" + board_title + ", board_content=" + board_content + ", cnt_like="
				+ cnt_like + ", view_cnt=" + view_cnt + ", board_idx=" + board_idx + ", user_id=" + user_id + "]";
	}

}
