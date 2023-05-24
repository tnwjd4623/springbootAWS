package com.example.springbootAWS.dto;

import com.example.springbootAWS.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat; // Junit의 assertThat과 달리 추가적인 라이브러리가 필요하지 않다고함

/**
 * @author Lee Su Jeong
 * @date 2023/05/24
 */

public class HelloResponseDtoTest {

    @Test
    public void 롬복_테스트() {
        // given
        String name = "test";
        int amount = 1000;
        
        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        
        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

