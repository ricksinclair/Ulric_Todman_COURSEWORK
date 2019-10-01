package com.trilogyed.stwitter.service;


import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    private ServiceLayer serviceLayer;
     private  CommentFeignClient commentFeignClient;
    private   PostFeignClient postFeignClient;



    private void commentMockSetUp() {

        commentFeignClient = mock(CommentFeignClient.class);

        Comment testComment1 = new Comment();
        testComment1.setCommentId(1);
        testComment1.setCommenterName("John Doe");
        testComment1.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment1.setPostId(1);
        testComment1.setComment("Does my opinion really matter?");

        Comment noIdTestComment1 = new Comment();
        noIdTestComment1.setCommenterName("John Doe");
        noIdTestComment1.setCommentDate(LocalDate.of(2019, 9, 30));
        noIdTestComment1.setPostId(1);
        noIdTestComment1.setComment("Does my opinion really matter?");

        Comment testComment2 = new Comment();
        testComment2.setCommentId(2);
        testComment2.setCommenterName("Jane Doe");
        testComment2.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment2.setPostId(1);
        testComment2.setComment("Does John's opinion really matter?");

        Comment noIdTestComment2 = new Comment();
        noIdTestComment2.setCommenterName("Jane Doe");
        noIdTestComment2.setCommentDate(LocalDate.of(2019, 9, 30));
        noIdTestComment2.setPostId(1);
        noIdTestComment2.setComment("Does John's opinion really matter?");

        Comment testComment3 = new Comment();
        testComment3.setCommentId(3);
        testComment3.setCommenterName("Jane Doe");
        testComment3.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment3.setPostId(2);
        testComment3.setComment("Where is the article?");

        Comment noIdTestComment3 = new Comment();
        noIdTestComment3.setCommenterName("Jane Doe");
        noIdTestComment3.setCommentDate(LocalDate.of(2019, 9, 30));
        noIdTestComment3.setPostId(2);
        noIdTestComment3.setComment("Where is the article?");

        //COMMENTS LISTS
        List<Comment> article1Comments = new ArrayList<>();
        article1Comments.add(testComment1);
        article1Comments.add(testComment2);

        List<Comment> article2Comments = new ArrayList<>();
        article2Comments.add(testComment3);


        doReturn(testComment1).when(commentFeignClient).getComment(1);
        doReturn(article1Comments).when(commentFeignClient).getCommentsByPostId(1);
        doReturn(article2Comments).when(commentFeignClient).getCommentsByPostId(2);
        doNothing().when(commentFeignClient).deleteComment(1);



    }


    private void postMockSetUp() {

        postFeignClient = mock(PostFeignClient.class);

        Post testPost1 = new Post();
        testPost1.setPosterName("John Doe");
        testPost1.setPostDate(LocalDate.of(2019, 9, 30));
        testPost1.setPost("This is a test post");


        Post testPost1WithId = new Post();
        testPost1WithId.setPostId(1);
        testPost1WithId.setPosterName("John Doe");
        testPost1WithId.setPostDate(LocalDate.of(2019, 9, 30));
        testPost1WithId.setPost("This is a test post");

        Post testPost2 = new Post();
        testPost2.setPosterName("John Doe");
        testPost2.setPostDate(LocalDate.of(2019, 9, 30));
        testPost2.setPost("This is test post 2");


        Post testPost2WithId = new Post();
        testPost2WithId.setPostId(2);
        testPost2WithId.setPosterName("John Doe");
        testPost2WithId.setPostDate(LocalDate.of(2019, 9, 30));
        testPost2WithId.setPost("This is test post 2");


        Post testPost3 = new Post();
        testPost3.setPosterName("Jane Doe");
        testPost3.setPostDate(LocalDate.of(2019, 9, 30));
        testPost3.setPost("This is a test post");

        Post testPost3WithId = new Post();
        testPost3WithId.setPostId(3);
        testPost3WithId.setPosterName("Jane Doe");
        testPost3WithId.setPostDate(LocalDate.of(2019, 9, 30));
        testPost3WithId.setPost("This is a test post");


        List<Post> postsByJohn = new ArrayList<>();
        postsByJohn.add(testPost1WithId);
        postsByJohn.add(testPost2WithId);

        List<Post> postsByJane = new ArrayList<>();
        postsByJane.add(testPost3WithId);


        doReturn(testPost1WithId).when(postFeignClient).createPost(testPost1);
        doReturn(testPost1WithId).when(postFeignClient).getPost(1);
        doReturn(testPost2WithId).when(postFeignClient).createPost(testPost2);
        doReturn(testPost2WithId).when(postFeignClient).getPost(2);
        doReturn(testPost3WithId).when(postFeignClient).createPost(testPost3);
        doReturn(testPost3WithId).when(postFeignClient).getPost(3);
        doReturn(postsByJohn).when(postFeignClient).getPostsByPosterName("John Doe");
        doReturn(postsByJane).when(postFeignClient).getPostsByPosterName("Jane Doe");
    }


    @Before
    public void setUp() throws Exception{
        postMockSetUp();
        commentMockSetUp();
        serviceLayer = new ServiceLayer(postFeignClient, commentFeignClient);
    }



    @Test
    public void addGetPost(){
        Post testPost1 = new Post();
        testPost1.setPosterName("John Doe");
        testPost1.setPostDate(LocalDate.of(2019, 9, 30));
        testPost1.setPost("This is a test post");

        PostViewModel pvm1 = serviceLayer.addPost(testPost1);

        PostViewModel pvmFromGet =serviceLayer.getPost(pvm1.getPostId());

        assertEquals(pvm1, pvmFromGet);

        assertEquals(pvm1.getComments().size(), 2);


    }

    @Test
    public void findComment(){
        Comment testComment1 = new Comment();
        testComment1.setCommentId(1);
        testComment1.setCommenterName("John Doe");
        testComment1.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment1.setPostId(1);
        testComment1.setComment("Does my opinion really matter?");
        assertEquals(serviceLayer.findComment(1), testComment1);
    }



}
