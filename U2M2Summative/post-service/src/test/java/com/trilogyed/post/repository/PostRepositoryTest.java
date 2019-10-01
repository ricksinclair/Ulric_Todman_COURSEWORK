package com.trilogyed.post.repository;


import com.trilogyed.post.model.Post;
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
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception{

        List<Post> postList = postRepository.findAll();

        postList.forEach(post -> {
            postRepository.deleteById(post.getPostId());
        });
    }

    @Test
    public void addGetDeletePost(){
        Post testPost1 = new Post();
        testPost1.setPosterName("John Doe");
        testPost1.setPostDate(LocalDate.of(2019, 9,30));
        testPost1.setPost("This is a test post");
        postRepository.save(testPost1);
        Post fromRepository = postRepository.findById(testPost1.getPostId()).orElse(null);
        assertEquals(testPost1, fromRepository);
        postRepository.deleteById(testPost1.getPostId());
        fromRepository = postRepository.findById(testPost1.getPostId()).orElse(null);
        assertNull(fromRepository);
    }

    @Test
    public void postLists(){
        Post testPost1 = new Post();
        testPost1.setPosterName("John Doe");
        testPost1.setPostDate(LocalDate.of(2019, 9,30));
        testPost1.setPost("This is a test post");
        postRepository.save(testPost1);
        Post testPost2 = new Post();
        testPost2.setPosterName("John Doe");
        testPost2.setPostDate(LocalDate.of(2019, 9,30));
        testPost2.setPost("This is test post 2");
        postRepository.save(testPost2);
        Post testPost3 = new Post();
        testPost3.setPosterName("Jane Doe");
        testPost3.setPostDate(LocalDate.of(2019, 9,30));
        testPost3.setPost("This is a test post");
        postRepository.save(testPost3);
        List<Post> postList = postRepository.findAll();
        assertEquals(3, postList.size());
        List<Post> johnsPosts = postRepository.findByPosterName("John Doe");
        assertEquals(2, johnsPosts.size());
    }
}
