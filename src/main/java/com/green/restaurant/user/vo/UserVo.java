package com.green.restaurant.user.vo;

import java.util.Date;

public class UserVo {
	private String userId;
	private String userPw;
	private String userTel;
	private String userDate;
	private Date joinDate;
	private Integer userState;
	private Integer likeRestaurant;
	private String userRole;
	
	//constructor
	public UserVo () {};
	
	public UserVo(String userId, String userPw, String userTel, String userDate, Date joinDate, Integer userState,
			Integer likeRestaurant, String userRole) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userTel = userTel;
		this.userDate = userDate;
		this.joinDate = joinDate;
		this.userState = userState;
		this.likeRestaurant = likeRestaurant;
		this.userRole = userRole;
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

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Integer getLikeRestaurant() {
		return likeRestaurant;
	}

	public void setLikeRestaurant(Integer likeRestaurant) {
		this.likeRestaurant = likeRestaurant;
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
		return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userTel=" + userTel + ", userDate=" + userDate
				+ ", joinDate=" + joinDate + ", userState=" + userState + ", likeRestaurant=" + likeRestaurant + ", userRole=" + userRole + "]";
	}
	
}
