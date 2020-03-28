package com.nowcoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {

    private Integer id;

    private String name;

    private String password;

    private String salt;

    private String headUrl;

    private Integer userRole;

    private Integer isDelete;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;

    public User() {
    }

    public User(String name){
        this.name = name;
    }

    public User(Integer id, String headUrl){
        this.id = id;
        this.headUrl = headUrl;
    }

    public User(Integer id, String name, String password, String salt, String headUrl, Integer userRole, Integer isDelete, Date createDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.headUrl = headUrl;
        this.userRole = userRole;
        this.isDelete = isDelete;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}