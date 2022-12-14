package com.green.restaurant.owner.vo;

public class OwnerCommentVo {
	//fields
	private int comment_idx;
	private String commentWriter;
	private String comment_content;
	private int commentBoardIdx;
	private String commentRegDate;
	private int lvl;
	private int step;
	private int cnum;
	private int nref;
	
	//constructor
	public OwnerCommentVo() {}
	
	public OwnerCommentVo(int comment_idx, String commentWriter, String comment_content, int commentBoardIdx,
			String commentRegDate, int lvl, int step, int cnum, int nref) {
		super();
		this.comment_idx = comment_idx;
		this.commentWriter = commentWriter;
		this.comment_content = comment_content;
		this.commentBoardIdx = commentBoardIdx;
		this.commentRegDate = commentRegDate;
		this.lvl = lvl;
		this.step = step;
		this.cnum = cnum;
		this.nref = nref;
	}

	//getter/setter
	public int getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getCommentBoardIdx() {
		return commentBoardIdx;
	}

	public void setCommentBoardIdx(int commentBoardIdx) {
		this.commentBoardIdx = commentBoardIdx;
	}

	public String getCommentRegDate() {
		return commentRegDate;
	}

	public void setCommentRegDate(String commentRegDate) {
		this.commentRegDate = commentRegDate;
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
		return "OwnerCommentVo [comment_idx=" + comment_idx + ", commentWriter=" + commentWriter + ", comment_content="
				+ comment_content + ", commentBoardIdx=" + commentBoardIdx + ", commentRegDate=" + commentRegDate
				+ ", lvl=" + lvl + ", step=" + step + ", cnum=" + cnum + ", nref=" + nref + "]";
	}
	
}
