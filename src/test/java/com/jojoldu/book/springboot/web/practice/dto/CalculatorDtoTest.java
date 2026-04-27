package com.jojoldu.book.springboot.web.practice.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorDtoTest {

    @Test
    public void add_메서드_검증() {

        // given

        CalculatorDto dto = CalculatorDto.builder()
                .a(10)
                .b(3)
                .build();

        // when
        int result = dto.add();

        // then
        // TODO: result가 13인지 검증
        assertThat(result).isEqualTo(13);

    }

    // TODO: subtract_메서드_검증 테스트도 추가
    @Test
    public void subtract_메서드_검증() {

        // given

        CalculatorDto dto = CalculatorDto.builder()
                .a(10)
                .b(3)
                .build();

        // when
        int result = dto.subtract();

        // then
        // TODO: result가 13인지 검증
        assertThat(result).isEqualTo(7);

    }
}
