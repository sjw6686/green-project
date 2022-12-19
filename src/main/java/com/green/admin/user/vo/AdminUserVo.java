package com.green.admin.user.vo;

public class AdminUserVo {
	
	private String user_Id;
	private String user_Pw;
	private String user_Tel;
	private String join_Date;
	private String user_Role;
	//사장정보
	private Integer ownerIdx;
	private String ownerNum;
	private char userEnable;
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Pw() {
		return user_Pw;
	}
	public void setUser_Pw(String user_Pw) {
		this.user_Pw = user_Pw;
	}
	public String getUser_Tel() {
		return user_Tel;
	}
	public void setUser_Tel(String user_Tel) {
		this.user_Tel = user_Tel;
	}
	public String getJoin_Date() {
		return join_Date;
	}
	public void setJoin_Date(String join_Date) {
		this.join_Date = join_Date;
	}
	public String getUser_Role() {
		return user_Role;
	}
	public void setUser_Role(String user_Role) {
		this.user_Role = user_Role;
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
	public AdminUserVo(String user_Id, String user_Pw, String user_Tel, String join_Date, String user_Role, Integer ownerIdx,
			String ownerNum, char userEnable) {
		super();
		this.user_Id = user_Id;
		this.user_Pw = user_Pw;
		this.user_Tel = user_Tel;
		this.join_Date = join_Date;
		this.user_Role = user_Role;
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
		return "UserVo [user_Id=" + user_Id + ", user_Pw=" + user_Pw + ", user_Tel=" + user_Tel + ", join_Date="
				+ join_Date + ", user_Role=" + user_Role + ", ownerIdx=" + ownerIdx + ", ownerNum=" + ownerNum
				+ ", userEnable=" + userEnable + "]";
	}
	
}
