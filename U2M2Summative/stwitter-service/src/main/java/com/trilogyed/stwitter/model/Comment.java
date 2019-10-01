package com.trilogyed.stwitter.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Comment implements  Serializable{


    private int commentId;
    @NotNull(message = "must include post id")
    private int postId;
    @NotNull(message = "must include creation date")
    private LocalDate commentDate;
    @NotNull(message = "Must include commenter name")
    @Size(max = 50, message = "size must be less than or equal to 50 characters")
    private String commenterName;
    @NotNull(message = "must include comment")
    @Size(max = 255, message = "size must be less than or equal to 255 characters")
    private String comment;

    public Comment() {

    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return getCommentId() == comment1.getCommentId() &&
                getPostId() == comment1.getPostId() &&
                getCommentDate().equals(comment1.getCommentDate()) &&
                getCommenterName().equals(comment1.getCommenterName()) &&
                getComment().equals(comment1.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getPostId(), getCommentDate(), getCommenterName(), getComment());
    }
}
