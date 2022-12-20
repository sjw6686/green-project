package com.green.admin.user.vo;

public class AdminUserVo {
	
	private String user_id;
	private String user_pw;
	private String user_tel;
	private String join_date;
	private String user_role;
	//사장정보
	private Integer ownerIdx;
	private String ownerNum;
	private char userEnable;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public Integer getOwnerIdx() {
		return ownerIdx;
	}
	public void setOwnerIdx(Integer ownerIdx) {
		this.ownerIdx = ownerIdx;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public char getUserEnable() {
		return userEnable;
	}
	public void setUserEnable(char userEnable) {
		this.userEnable = userEnable;
	}
	public AdminUserVo(String user_id, String user_pw, String user_tel, String join_date, String user_role,
			Integer ownerIdx, String ownerNum, char userEnable) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_tel = user_tel;
		this.join_date = join_date;
		this.user_role = user_role;
		this.ownerIdx = ownerIdx;
		this.ownerNum = ownerNum;
		this.userEnable = userEnable;
	}
	public AdminUserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminUserVo [user_id=" + user_id + ", user_pw=" + user_pw + ", user_tel=" + user_tel + ", join_date="
				+ join_date + ", user_role=" + user_role + ", ownerIdx=" + ownerIdx + ", ownerNum=" + ownerNum
				+ ", userEnable=" + userEnable + "]";
	}

	
}
