package com.example.springbootAWS.web.dto;

import com.example.springbootAWS.domain.posts.Posts;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lee Su Jeong
 * @date 2023/08/02
 */

@Getter
public class PostsResponseDto {
    
    private Long id;
    private String title;
    private String content;
    private String author;
    
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

