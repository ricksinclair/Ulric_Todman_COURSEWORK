package com.trilogyed.post.controller;

import com.trilogyed.post.model.Post;
import com.trilogyed.post.repository.PostRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"posts"})
public class PostController {

    @Autowired
    PostRepository postRepository;

        @CachePut(key = "#result.getPostId()")
        @RequestMapping(value = "/posts", method = RequestMethod.POST)
        public Post createPost(@RequestBody Post post) {

        return postRepository.save(post);
    }


    @RequestMapping(value = "/posts/poster/{posterName}", method = RequestMethod.GET)
    public List<Post> getPostsByPosterName(@PathVariable String posterName){
        return postRepository.findByPosterName(posterName);
    }

    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        Optional<Post> post = postRepository.findById(id);

        return post.orElse(null);
    }

    @CacheEvict(key = "#post.getPostId()")
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {

        if(post.getPostId()!=0 && id==post.getPostId()) {
            postRepository.save(post);
        }else{
            throw new IllegalArgumentException("Post must have valid id and must match id in path");
        }
    }

    @CacheEvict
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {

        postRepository.deleteById(id);

    }
}
