package com.jojoldu.book.springboot.web.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
// TODO: @Builder 어노테이션 추가
@Builder
@AllArgsConstructor
public class CalculatorDto {

    private int a;
    private int b;

    // TODO: @Builder가 동작하려면 어떤 생성자가 필요한지 생각해보세요
    //       (힌트: AllArgsConstructor)

    public int add() {

        // TODO: a + b 반환
        return a + b;

    }

    public int subtract() {

        // TODO: a - b 반환
        return a - b;

    }

}
