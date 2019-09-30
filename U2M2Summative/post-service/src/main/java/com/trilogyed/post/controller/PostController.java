package com.trilogyed.post.controller;

import com.netflix.discovery.converters.Auto;
import com.trilogyed.post.model.Post;
import com.trilogyed.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {

        return postRepository.save(post);
    }


    @RequestMapping(value = "/posts/poster/{posterName}", method = RequestMethod.GET)
    public List<Post> getPostsByPosterName(@PathVariable String posterName){
        return postRepository.findByPosterName(posterName);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return postRepository.findById(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {

        if(post.getPostID()!=0 && id==post.getPostID()) {
            postRepository.save(post);
        }else{
            throw new IllegalArgumentException("Post must have valid id and must match id in path");
        }
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public void deletePost(@PathVariable int id) {

        postRepository.deleteById(id);

    }
}
