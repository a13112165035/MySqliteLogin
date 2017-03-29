package com.example.administrator.mysqlitelr.model;

/**
 * Created by Administrator on 2017/3/24.
 */

public class UserModel {
    public UserModel() {
    }

    private String username;
    private String password;
    private Integer count;

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", count=" + count +
                '}';
    }

    public UserModel( Integer count,String username, String password) {
        this.username = username;
        this.password = password;
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
