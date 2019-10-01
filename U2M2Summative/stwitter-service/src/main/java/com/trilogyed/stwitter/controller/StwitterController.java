package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StwitterController {


    @Autowired
    ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public PostViewModel createNewPost(@Valid @RequestBody Post post) {
        return service.addPost(post);
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int postId) {
        return service.getPost(postId);
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable int postId) {
        service.deletePost(postId);
    }

    @RequestMapping(value = "/post", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@Valid @RequestBody Post post) {
        service.updatePost(post);
    }


    @RequestMapping(value = "/posts/poster/{posterName}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<PostViewModel> getPostsByPoster(@PathVariable String posterName){
        return service.getPostsByPoster(posterName);
    }


    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addComment(@Valid @RequestBody Comment comment){
        service.addComment(comment);
    }

    @RequestMapping(value ="/comment", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatedComment(@Valid @RequestBody Comment comment){
        service.updateComment(comment);
    }

    @RequestMapping(value ="/comment/{commentId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment(@PathVariable int commentId){
      return   service.findComment(commentId);
    }
    @RequestMapping(value ="/comment/{commentId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteComment(@PathVariable int commentId){
         service.deleteComment(commentId);
    }




}
