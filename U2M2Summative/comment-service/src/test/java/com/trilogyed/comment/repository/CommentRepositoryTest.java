package com.trilogyed.comment.repository;


import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Before
    public void setUp() throws Exception{
        List<Comment> commentList = commentRepository.findAll();
        commentList.forEach(comment -> {
            commentRepository.deleteById(comment.getCommentId());
        });

    }


    @Test
    public void addGetDeleteComment(){
        Comment testComment1 = new Comment();
        testComment1.setCommenterName("John Doe");
        testComment1.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment1.setPostId(1);
        testComment1.setComment("Does my opinion really matter?");

        commentRepository.save(testComment1);
        Comment fromRepository = commentRepository.findById(testComment1.getCommentId()).orElse(null);
        assertEquals(testComment1, fromRepository);
        commentRepository.deleteById(testComment1.getCommentId());
        fromRepository = commentRepository.findById(testComment1.getCommentId()).orElse(null);
        assertNull(fromRepository);
    }


    @Test
    public void commentLists(){
        Comment testComment1 = new Comment();
        testComment1.setCommenterName("John Doe");
        testComment1.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment1.setPostId(1);
        testComment1.setComment("Does my opinion really matter?");

        commentRepository.save(testComment1);

          Comment testComment2 = new Comment();
        testComment2.setCommenterName("Jane Doe");
        testComment2.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment2.setPostId(1);
        testComment2.setComment("Does John's opinion really matter?");

        commentRepository.save(testComment2);

        Comment testComment3 = new Comment();
        testComment3.setCommenterName("Jane Doe");
        testComment3.setCommentDate(LocalDate.of(2019, 9, 30));
        testComment3.setPostId(2);
        testComment3.setComment("Where is the article?");

        commentRepository.save(testComment3);

        List<Comment> commentList = commentRepository.findByPostId(1);

        assertEquals(commentList.size(), 2);



    }

}
