package com.nowcoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class News {

    private Integer id;

    private String title;

    private String link;

    private String image;

    private Integer likeCount;

    private Integer commentCount;

    private Integer userId;

    private Integer isDelete;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdDate;

    public News(){

    }

    public News(Integer id, String title, String link, String image, Integer likeCount, Integer commentCount, Integer userId, Integer isDelete, Date createdDate) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.image = image;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.userId = userId;
        this.isDelete = isDelete;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}