package com.green.restaurant.owner.vo;

import java.util.Date;

public class OwnerVo {
	private String ownerId;
	private String ownerNum;
	private String ownerPw;
	private String ownerName;
	private String ownerTel;
	private boolean ownerEnable;
	private Date joinDate;
	private String userRole;
	
	//constructor
	public OwnerVo() {};
	
	public OwnerVo(String ownerId, String ownerNum, String ownerPw, String ownerName, String ownerTel,
			boolean ownerEnable, Date joinDate, String userRole) {
		super();
		this.ownerId = ownerId;
		this.ownerNum = ownerNum;
		this.ownerPw = ownerPw;
		this.ownerName = ownerName;
		this.ownerTel = ownerTel;
		this.ownerEnable = ownerEnable;
		this.joinDate = joinDate;
		this.userRole = userRole;
	}
	
	//getter/setter
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getOwnerPw() {
		return ownerPw;
	}
	public void setOwnerPw(String ownerPw) {
		this.ownerPw = ownerPw;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerTel() {
		return ownerTel;
	}
	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}
	public boolean isOwnerEnable() {
		return ownerEnable;
	}
	public void setOwnerEnable(boolean ownerEnable) {
		this.ownerEnable = ownerEnable;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	//toString
	@Override
	public String toString() {
		return "OwnerVo [ownerId=" + ownerId + ", ownerNum=" + ownerNum + ", ownerPw=" + ownerPw + ", ownerName="
				+ ownerName + ", ownerTel=" + ownerTel + ", ownerEnable=" + ownerEnable + ", joinDate=" + joinDate
				+ ", userRole=" + userRole + "]";
	}
	
}
