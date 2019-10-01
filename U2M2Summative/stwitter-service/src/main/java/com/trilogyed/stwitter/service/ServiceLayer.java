package com.trilogyed.stwitter.service;


import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {
    public static final String TOPIC_EXCHANGE_NAME = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.#";


    @Autowired
    private  CommentFeignClient commentFeignClient;

    @Autowired
    private  PostFeignClient postFeignClient;

    @Autowired
    private
    RabbitTemplate rabbitTemplate;


    public ServiceLayer(){

    }

    public ServiceLayer(PostFeignClient postFeignClient, CommentFeignClient commentRepository) {
        this.commentFeignClient = commentRepository;
        this.postFeignClient = postFeignClient;

    }

/*
  //////////////////////////////////
  //////////////////////////////////
  ////Post methods /////////////////
  //////////////////////////////////
  //////////////////////////////////
  */


    public PostViewModel addPost(Post post) {
        return buildPostViewModel(postFeignClient.createPost(post));
    }

    public PostViewModel getPost(int postId) {
        Post post = postFeignClient.getPost(postId);
        return buildPostViewModel(post);
    }

    public void updatePost(Post post) {
        postFeignClient.updatePost(post, post.getPostId());
    }

    public void deletePost(int postId) {

        postFeignClient.deletePost(postId);
    }

    public List<PostViewModel> getPostsByPoster(String posterName) {
        List<Post> userPosts = postFeignClient.getPostsByPosterName(posterName);
        List<PostViewModel> userPostViewModels = new ArrayList<>();

        userPosts.forEach(post -> {
            userPostViewModels.add(buildPostViewModel(post));
        });

        return userPostViewModels;
    }

    /*
      //////////////////////////////////
      //////////////////////////////////
      ////Comment methods //////////////
      //////////////////////////////////
      //////////////////////////////////
      */
    public void deleteComment(int commentId) {
        commentFeignClient.deleteComment(commentId);
    }

    public void addComment(Comment comment) {
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, comment);

    }

    public void updateComment(Comment comment) {
        //check to make sure it is the same commenter sending the updated comment.
        if (comment.getCommentId() != 0 && comment.getCommenterName()
                .equals(commentFeignClient.getComment(comment.getCommentId()).getCommenterName())) {
            rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, comment);
        } else { //otherwise throw an exception
            throw new IllegalArgumentException("Must be a valid comment and from same commenter");
        }
    }

    public Comment findComment(int commentId) {
        return commentFeignClient.getComment(commentId);
    }





    private PostViewModel buildPostViewModel(Post post) {
        PostViewModel pvm = new PostViewModel();
        pvm.setPost(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setComments(commentFeignClient.getCommentsByPostId(post.getPostId()));
        pvm.setPostId(post.getPostId());
        return pvm;
    }


}
