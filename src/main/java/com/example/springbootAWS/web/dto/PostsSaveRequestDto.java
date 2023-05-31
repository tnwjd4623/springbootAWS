package com.example.springbootAWS.web.dto;

import com.example.springbootAWS.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */
 
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {  // Entity와 비슷하지만 절대로 Entity를 Request나 Response형태로 사용하면 안됨. Entity는 데이터베이스에 사용되는 클래스임
    private String title;
    private String content;
    private String author;
    
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

