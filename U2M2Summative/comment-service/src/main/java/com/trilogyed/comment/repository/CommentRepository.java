package com.trilogyed.comment.repository;

import com.trilogyed.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Transactional
    public Optional<Comment> findById(int id);

    public List<Comment> findByPostId(int postId);

}
