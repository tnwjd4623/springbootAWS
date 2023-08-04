package com.example.springbootAWS.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Lee Su Jeong
 * @date 2023/08/04
 */
// 단순 반복적인 audit 코드를 해결할 수 있다
@Getter
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 Date 필드들도 칼럼으로 인식하도록 한다
@EntityListeners(AuditingEntityListener.class)  // JPA Auditing
public abstract class BaseTimeEntity {
    
    @CreatedDate    // Entity 생성 시간
    private LocalDateTime createdDate;
    
    @LastModifiedDate // Entity 변경 시간
    private LocalDateTime modifiedDate;
}

