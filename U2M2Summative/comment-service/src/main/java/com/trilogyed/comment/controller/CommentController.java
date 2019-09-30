package com.trilogyed.comment.controller;

import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    @RequestMapping(path = "/comments/byPosts/{postId}", method = RequestMethod.GET)
    public List<Comment> getPostsByPostId(@PathVariable int postId){
       return  commentRepository.findByPostId(postId);
    }

    @RequestMapping(path = "/comments/{commentId}", method=RequestMethod.GET)
    public Comment getComment(@PathVariable int commentId){
        return commentRepository.findById(commentId);
    }

    @RequestMapping(path = "/comments/{commentId}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment,@PathVariable int commentId){
        if(comment.getCommentId()!=0 && commentId == comment.getCommentId()){
            commentRepository.save(comment);
        }else{
            throw new IllegalArgumentException("Comment id must match value in path");
        }
    }

    @RequestMapping(path = "/comments/{commentId}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int commentId){
        commentRepository.deleteById(commentId);
    }
}


