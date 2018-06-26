package com.notify.NotifyEgerton.Model.Post;


public class Post {
    
    private String username;
    private String datePosted;
    private String timePosted;
    private String notice;
    private String likeCount;
    private int id;
    private String commentCount;

    public Post() {
    }

    public Post(String username, String datePosted, String timePosted, String notice, String likeCount, String commentCount) {
        this.username = username;
        this.datePosted = datePosted;
        this.timePosted = timePosted;
        this.notice = notice;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(String timePosted) {
        this.timePosted = timePosted;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }
    
    
}
