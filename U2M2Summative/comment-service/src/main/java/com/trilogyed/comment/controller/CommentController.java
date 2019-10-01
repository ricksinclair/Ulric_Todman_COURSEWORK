package com.trilogyed.comment.controller;

import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CacheConfig(cacheNames = {"comments"})
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @CachePut(key = "#result.getCommentId()")
    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    @RequestMapping(path = "/comments/byPosts/{postId}", method = RequestMethod.GET)
    public List<Comment> getCommentsByPostId(@PathVariable int postId){
       return  commentRepository.findByPostId(postId);
    }

    @Cacheable
    @RequestMapping(path = "/comments/{commentId}", method=RequestMethod.GET)
    public Comment getComment(@PathVariable int commentId){
        return commentRepository.findById(commentId).orElse(null);
    }

    @CacheEvict(key = "#comment.getCommentId()")
    @RequestMapping(path = "/comments/{commentId}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment,@PathVariable int commentId){
        if(comment.getCommentId()!=0 && commentId == comment.getCommentId()){
            commentRepository.save(comment);
        }else{
            throw new IllegalArgumentException("Comment id must match value in path");
        }
    }

    @CacheEvict
    @RequestMapping(path = "/comments/{commentId}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int commentId){
        commentRepository.deleteById(commentId);
    }
}


