package com.trilogyed.post.repository;

import com.trilogyed.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Transactional
    public Post findById(int id);


    public List<Post> findByPosterName(String posterName);
}
