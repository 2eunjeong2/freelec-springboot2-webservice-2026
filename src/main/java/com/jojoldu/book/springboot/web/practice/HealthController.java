package com.jojoldu.book.springboot.web.practice;

import com.jojoldu.book.springboot.web.practice.dto.HealthResponseDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;


// TODO: 필요한 import 추가

@RestController
public class HealthController {

    // TODO: GET /health
    @GetMapping("/health")

    public HealthResponseDto health() {

        // TODO: HealthResponseDto를 생성해서 반환
        //       status는 "OK", timestamp는 LocalDateTime.now()
        return new HealthResponseDto("OK", LocalDateTime.now());
    }

}
