package com.nowcoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 评论实体类
 */
public class Comment {

    private Integer id;

    private String content;

    private Integer userId;

    private Integer entityId;

    private Integer entityType;

    private Integer isDelete;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdDate;

    public Comment(){

    }

    public Comment(Integer id, String content, Integer userId, Integer entityId, Integer entityType, Integer isDelete, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.entityId = entityId;
        this.entityType = entityType;
        this.isDelete = isDelete;
        this.createdDate = createdDate;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
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