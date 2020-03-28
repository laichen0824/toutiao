package com.nowcoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LoginTicket {

    private Integer id;

    private Integer userId;

    private String ticket;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date expired;

    private Integer status;

    public LoginTicket() {
    }

    public LoginTicket(Integer id, Integer userId, String ticket, Date expired, Integer status) {
        this.id = id;
        this.userId = userId;
        this.ticket = ticket;
        this.expired = expired;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}