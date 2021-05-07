package com.ssafy.happyhouse.dto;

import java.io.Serializable;

public class JoinDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;
    private String userPwd;
    private String email;
    private String address;
    private String joinDate;
    public JoinDto() {}

    public JoinDto(String userId, String userName, String userPwd, String email, String address) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.email = email;
        this.address = address;
    }

    
    public JoinDto(String userId, String userName, String userPwd, String email, String address, String joinDate) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.email = email;
        this.address = address;
        this.joinDate = joinDate;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    
    
}