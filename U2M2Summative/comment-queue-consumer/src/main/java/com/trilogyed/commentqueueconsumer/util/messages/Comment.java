package com.trilogyed.commentqueueconsumer.util.messages;

import java.time.LocalDate;

public class Comment {

    private int commentId;
    private int postId;
    private LocalDate commentDate;
    private String commenterName;
    private String comment;

    public Comment(){

    }

    public Comment(int commentId, int postId, LocalDate commentDate, String commenterName, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentDate = commentDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commentDate=" + commentDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
