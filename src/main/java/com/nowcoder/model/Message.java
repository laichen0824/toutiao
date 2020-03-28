package com.nowcoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Message {

    private Integer id;

    private Integer fromId;

    private Integer toId;

    private String content;

    private Integer hasRead;

    private String conversationId;

    private Integer isDelete;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdDate;

    public Message(){

    }

    public Message(Integer id, Integer fromId, Integer toId, String content, Integer hasRead, String conversationId, Integer isDelete, Date createdDate) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.content = content;
        this.hasRead = hasRead;
        this.conversationId = conversationId;
        this.isDelete = isDelete;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHasRead() {
        return hasRead;
    }

    public void setHasRead(Integer hasRead) {
        this.hasRead = hasRead;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
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