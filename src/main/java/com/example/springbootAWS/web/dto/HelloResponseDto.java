package com.example.springbootAWS.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Lee Su Jeong
 * @date 2023/05/24
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    
    private final String name;
    private final int amount;
}

