package com.trilogyed.stwitter.service;


import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceLayerTest {

ServiceLayer serviceLayer;
CommentFeignClient commentFeignClient;
PostFeignClient postFeignClient;


private void commentMockSetUp(){

    CommentFeignClient commentFeignClient = mock(CommentFeignClient.class);

    Comment testComment1 = new Comment();
    testComment1.setCommentId(1);
    testComment1.setCommenterName("John Doe");
    testComment1.setCreateDate(LocalDate.of(2019, 9, 30));
    testComment1.setPostId(1);
    testComment1.setComment("Does my opinion really matter?");

    Comment noIdTestComment1 = new Comment();
    noIdTestComment1.setCommenterName("John Doe");
    noIdTestComment1.setCreateDate(LocalDate.of(2019, 9, 30));
    noIdTestComment1.setPostId(1);
    noIdTestComment1.setComment("Does my opinion really matter?");

    Comment testComment2 = new Comment();
    testComment2.setCommentId(2);
    testComment2.setCommenterName("Jane Doe");
    testComment2.setCreateDate(LocalDate.of(2019, 9, 30));
    testComment2.setPostId(1);
    testComment2.setComment("Does John's opinion really matter?");

    Comment noIdTestComment2 = new Comment();
    noIdTestComment2.setCommenterName("Jane Doe");
    noIdTestComment2.setCreateDate(LocalDate.of(2019, 9, 30));
    noIdTestComment2.setPostId(1);
    noIdTestComment2.setComment("Does John's opinion really matter?");

    Comment testComment3 = new Comment();
    testComment3.setCommentId(3);
    testComment3.setCommenterName("Jane Doe");
    testComment3.setCreateDate(LocalDate.of(2019, 9, 30));
    testComment3.setPostId(2);
    testComment3.setComment("Where is the article?");

    Comment noIdTestComment3 = new Comment();
    noIdTestComment3.setCommenterName("Jane Doe");
    noIdTestComment3.setCreateDate(LocalDate.of(2019, 9, 30));
    noIdTestComment3.setPostId(2);
    noIdTestComment3.setComment("Where is the article?");

    //ALL COMMENTS LIST
    List<Comment> allComments = new ArrayList<>();
    allComments.add(testComment1);
    allComments.add(testComment2);
    allComments.add(testComment3);

    List<Comment> article1Comments = new ArrayList<>();
   article1Comments.add(testComment1);
   article1Comments.add(testComment2);

   List<Comment> article2Comments = new ArrayList<>();
   article2Comments.add(testComment3);


   doReturn(testComment1).when(commentFeignClient).getComment(1);




}



}
