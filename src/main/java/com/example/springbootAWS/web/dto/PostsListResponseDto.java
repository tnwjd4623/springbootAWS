package com.example.springbootAWS.web.dto;

import com.example.springbootAWS.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author Lee Su Jeong
 * @date 2023/08/08
 */

@Getter
public class PostsListResponseDto {
    
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    
    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}

