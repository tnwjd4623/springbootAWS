package com.example.springbootAWS.web;

import com.example.springbootAWS.service.posts.PostsService;
import com.example.springbootAWS.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    
    private final PostsService postsService;
    
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
    
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
}

