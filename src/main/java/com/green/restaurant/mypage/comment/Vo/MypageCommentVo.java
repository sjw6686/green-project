package com.green.restaurant.mypage.comment.Vo;

public class MypageCommentVo {
	private String comment_content;
	private String Reg_date;
	private int comment_idx;
	private String user_id;
	public MypageCommentVo() {}
	public MypageCommentVo(String comment_content, String reg_date, int comment_idx, String user_id) {
		super();
		this.comment_content = comment_content;
		Reg_date = reg_date;
		this.comment_idx = comment_idx;
		this.user_id = user_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getReg_date() {
		return Reg_date;
	}
	public void setReg_date(String reg_date) {
		Reg_date = reg_date;
	}
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "MypageCommentVo [comment_content=" + comment_content + ", Reg_date=" + Reg_date + ", comment_idx="
				+ comment_idx + ", user_id=" + user_id + "]";
	}
		
}
