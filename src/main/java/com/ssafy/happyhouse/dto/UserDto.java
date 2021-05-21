package com.ssafy.happyhouse.dto;

public class UserDto {

	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String address;
	private String registerTime;
	private boolean isAdmin;
	
	public UserDto() {}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserDto{");
		sb.append("userId='").append(userId).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", userPwd='").append(userPwd).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", address='").append(address).append('\'');
		sb.append(", registerTime='").append(registerTime).append('\'');
		sb.append(", isAdmin=").append(isAdmin);
		sb.append('}');
		return sb.toString();
	}

	public UserDto(String userId, String userName, String userPwd, String email, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.address = address;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	public UserDto(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

}

