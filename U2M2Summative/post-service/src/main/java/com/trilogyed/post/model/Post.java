package com.trilogyed.post.model;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postID;
    private LocalDate postDate;
    private String posterName;
    private String post;

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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

    public Post(){

    }

    public Post(int postID, LocalDate postDate, String posterName, String post) {
        this.postID = postID;
        this.postDate = postDate;
        this.posterName = posterName;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return getPostID() == post1.getPostID() &&
                getPostDate().equals(post1.getPostDate()) &&
                getPosterName().equals(post1.getPosterName()) &&
                getPost().equals(post1.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostID(), getPostDate(), getPosterName(), getPost());
    }
}
