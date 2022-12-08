package com.green.restaurant.user.vo;

public class UserVo {
	//유저정보
	private String userId;
	private String userPw;
	private String userTel;
	private String joinDate;
	private Integer likeIdx;
	private String userRole;
	//사장정보
	private Integer ownerIdx;
	private String ownerNum;
	private Integer restaurantIdx;
	private char userEnable;
		
	//constructor
	public UserVo() {};
		
	public UserVo(String userId, String userPw, String userTel, String joinDate, Integer likeIdx, String userRole,
			Integer ownerIdx, String ownerNum, Integer restaurantIdx, char userEnable) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userTel = userTel;
		this.joinDate = joinDate;
		this.likeIdx = likeIdx;
		this.userRole = userRole;
		this.ownerIdx = ownerIdx;
		this.ownerNum = ownerNum;
		this.restaurantIdx = restaurantIdx;
		this.userEnable = userEnable;
	}
		
	//getter/setter
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public Integer getLikeIdx() {
		return likeIdx;
	}
	public void setLikeIdx(Integer likeIdx) {
		this.likeIdx = likeIdx;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
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
	public Integer getRestaurantIdx() {
		return restaurantIdx;
	}
	public void setRestaurantIdx(Integer restaurantIdx) {
		this.restaurantIdx = restaurantIdx;
	}
	public char getUserEnable() {
		return userEnable;
	}
	public void setUserEnable(char userEnable) {
		this.userEnable = userEnable;
	}
		
	//toString
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userTel=" + userTel + ", joinDate=" + joinDate
				+ ", likeIdx=" + likeIdx + ", userRole=" + userRole + ", ownerIdx=" + ownerIdx + ", ownerNum="
				+ ownerNum + ", restaurantIdx=" + restaurantIdx + ", userEnable=" + userEnable + "]";
	}
}
