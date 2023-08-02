package com.example.springbootAWS.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Lee Su Jeong
 * @date 2023/08/02
 */

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    
    private String title;
    private String content;
    
    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

