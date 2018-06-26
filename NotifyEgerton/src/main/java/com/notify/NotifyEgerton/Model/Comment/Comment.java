package com.notify.NotifyEgerton.Model.Comment;

public class Comment {

private long id;
String commentPosted;
private long postId;

    public Comment() {
    }

    public Comment(String commentPosted, long postId) {
        this.commentPosted = commentPosted;
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentPosted() {
        return commentPosted;
    }

    public void setCommentPosted(String commentPosted) {
        this.commentPosted = commentPosted;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }





}
