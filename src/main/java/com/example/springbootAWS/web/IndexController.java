package com.example.springbootAWS.web;

import com.example.springbootAWS.service.posts.PostsService;
import com.example.springbootAWS.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Lee Su Jeong
 * @date 2023/08/08
 */

@RequiredArgsConstructor
@Controller // Controller 는 주로 View 를 리턴할 때 사용된다.
public class IndexController {
    
    private final PostsService postsService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
    
    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }
    
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}

