package com.trilogyed.stwitter.viewmodel;

import com.trilogyed.stwitter.model.Comment;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int postId;
    private LocalDate postDate;
    private String posterName;
    private String post;
    private List<Comment> comments;

    public PostViewModel(){

    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return getPostId() == that.getPostId() &&
                getPostDate().equals(that.getPostDate()) &&
                getPosterName().equals(that.getPosterName()) &&
                getPost().equals(that.getPost()) &&
                getComments().equals(that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPostDate(), getPosterName(), getPost(), getComments());
    }
}
