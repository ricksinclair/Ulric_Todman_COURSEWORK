package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostFeignClient {

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    Post createPost(@RequestBody Post post);

    @RequestMapping(value = "/posts/poster/{posterName}", method = RequestMethod.GET)
    List<Post> getPostsByPosterName(@PathVariable String posterName);


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    Post getPost(@PathVariable int id);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    void updatePost(@RequestBody Post post, @PathVariable int id);


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    void deletePost(@PathVariable int id);


}
