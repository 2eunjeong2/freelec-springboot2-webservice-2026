package com.jojoldu.book.springboot.web.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    // TODO: GET /echo/{message} 매핑
    @GetMapping("/echo/{message}")
    public String echo(/* TODO: @PathVariable 적용 */ @PathVariable String message) {

        // TODO: message를 거꾸로 뒤집어 반환
        //       (힌트: new StringBuilder(message).reverse().toString())
        return new StringBuilder(message).reverse().toString();

    }

}
