package com.udemy.spring_basic.domain;

public class Users {
    private Long userIdx;
    private String userId;
    private String userName;

    public Long getUserIdx() {
        return userIdx;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}