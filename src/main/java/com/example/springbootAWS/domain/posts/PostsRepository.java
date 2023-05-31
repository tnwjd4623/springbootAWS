package com.example.springbootAWS.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {    // <Entity 클래스, PK 타입>
}
