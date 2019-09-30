package com.trilogyed.comment.repository;

import com.trilogyed.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Transactional
    public Comment findById(int id);

    public List<Comment> findByPostId(int postId);

}
