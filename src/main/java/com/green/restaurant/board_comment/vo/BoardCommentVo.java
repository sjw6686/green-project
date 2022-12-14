package com.green.restaurant.board_comment.vo;

public class BoardCommentVo {
	
	private  int comment_idx;
	private String user_id;
	private String comment_content;
	private int board_idx;
	private String reg_date;
	private int lvl;
	private int step;
	private int cnum;
	private int nref;
	
	
	//Constructor
	public BoardCommentVo() {
		
	}
	public BoardCommentVo(int comment_idx, String user_id, String comment_content, int board_idx, String reg_date,
			int lvl, int step, int cnum, int nref, int file_idx) {
		super();
		this.comment_idx = comment_idx;
		this.user_id = user_id;
		this.comment_content = comment_content;
		this.board_idx = board_idx;
		this.reg_date = reg_date;
		this.lvl = lvl;
		this.step = step;
		this.cnum = cnum;
		this.nref = nref;
	}
	
	
	//getter /setter
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
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
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
		return "BoardCommentVo [comment_idx=" + comment_idx + ", user_id=" + user_id + ", comment_content="
				+ comment_content + ", board_idx=" + board_idx + ", reg_date=" + reg_date + ", lvl=" + lvl + ", step="
				+ step + ", cnum=" + cnum + ", nref=" + nref + ", file_idx="  + "]";
	}

	
		
}
