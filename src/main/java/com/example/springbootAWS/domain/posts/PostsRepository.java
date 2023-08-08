package com.example.springbootAWS.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {    // <Entity 클래스, PK 타입>
    
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
