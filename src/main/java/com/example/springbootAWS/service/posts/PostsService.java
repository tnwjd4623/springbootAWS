package com.example.springbootAWS.service.posts;

import com.example.springbootAWS.domain.posts.PostsRepository;
import com.example.springbootAWS.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}

