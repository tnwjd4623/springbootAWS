package com.example.springbootAWS.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    
    @Autowired
    PostsRepository postsRepository;
    
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }
    
    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "게시글";
        String content = "본문";
        
        postsRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("test@gmail.com")
                            .build());
        
        //when
        List<Posts> postsList = postsRepository.findAll();
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
    
    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2023, 8, 4, 0, 0, 0 );
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        
        //when
        List<Posts> postsList = postsRepository.findAll();
        
        //then
        Posts posts = postsList.get(0);
        
        System.out.println(">>>>>> createDate = "+posts.getCreatedDate() + ", modifiedDate = "+posts.getModifiedDate());
        
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
        
    }
}

