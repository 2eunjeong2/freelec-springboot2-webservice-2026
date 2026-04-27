package com.jojoldu.book.springboot.web.practice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class HealthResponseDto {

    private final String status;
    private final LocalDateTime timestamp;

}
