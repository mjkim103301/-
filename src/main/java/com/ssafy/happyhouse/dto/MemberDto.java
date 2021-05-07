package com.ssafy.happyhouse.dto;

public class MemberDto {

	private String userid;
	private String username;
	private String userpwd;
	private String email;
	private String address;
	private String joindate;
	private boolean canUseId;
	private boolean isAdmin;
	
	public MemberDto() {}

	public MemberDto(String userid, String username, String userpwd, String email, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDto [userid=").append(userid).append(", username=").append(username).append(", userpwd=")
				.append(userpwd).append(", email=").append(email).append(", address=").append(address)
				.append(", joindate=").append(joindate).append(", canUseId=").append(canUseId).append(", isAdmin=")
				.append(isAdmin).append("]");
		return builder.toString();
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public MemberDto(String userid) {
		this.userid = userid;
	}
	
	public MemberDto(String userid, boolean canUseId) {
		this.userid=userid;
		this.canUseId=canUseId;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
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

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public boolean isCanUseId() {
		return canUseId;
	}
	public void setCanUseId(boolean canUseId) {
		this.canUseId = canUseId;
	}

}

