package com.green.restaurant.mypage.board.Vo;

public class MypageBoardVo {
	private String board_title;
	private String board_content;
	private int view_cnt;
	private int board_idx;
	private String user_id;
	public MypageBoardVo() {}
	public MypageBoardVo(String board_title, String board_content, int view_cnt, int board_idx, String user_id) {
		super();
		this.board_title = board_title;
		this.board_content = board_content;
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
		return "MypageBoardVo [board_title=" + board_title + ", board_content=" + board_content + ", view_cnt="
				+ view_cnt + ", board_idx=" + board_idx + ", user_id=" + user_id + "]";
	}
			
}
