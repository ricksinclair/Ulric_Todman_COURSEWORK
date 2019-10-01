package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {

    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment);




    @RequestMapping(path = "/comments/{commentId}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment,@PathVariable int commentId);





}
