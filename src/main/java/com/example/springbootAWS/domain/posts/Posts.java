package com.example.springbootAWS.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Lee Su Jeong
 * @date 2023/05/31
 */

@Getter
@NoArgsConstructor
@Entity // Entity에서는 절대 Setter를 만들지 않는다, 대신 명확한 Function사용
public class Posts {
    
    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;
    
    @Column(length = 500, nullable = false) // 굳이 선언하지 않아도 column이 되긴 함, default = varchar(255)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private String author;
    
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

