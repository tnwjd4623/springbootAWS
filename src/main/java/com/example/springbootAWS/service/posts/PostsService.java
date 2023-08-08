package com.example.springbootAWS.service.posts;

import com.example.springbootAWS.domain.posts.Posts;
import com.example.springbootAWS.domain.posts.PostsRepository;
import com.example.springbootAWS.web.dto.PostsListResponseDto;
import com.example.springbootAWS.web.dto.PostsResponseDto;
import com.example.springbootAWS.web.dto.PostsSaveRequestDto;
import com.example.springbootAWS.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    
    /*
        쿼리를 날리지 않고 가능한 이유는 JPA의 영속성 컨텍스트 때문이다.
        영속성 컨텍스트 : 엔티티를 영구 저장하는 환경 *더티 체킹
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= "+id));
        
        posts.update(requestDto.getTitle(), requestDto.getContent());
        
        return id;
    }
    
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= "+id));
        return new PostsResponseDto(entity);
    }
    
    @Transactional(readOnly = true) //읽기만 할 때 성능 향상을 위해 사용한다
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }
}

