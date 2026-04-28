package com.jojoldu.book.springboot.domain.posts;

import jakarta.persistence.*;                  // ⚠️ jakarta (javax 아님)
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)   // JPA 전용
@Entity                                              // DB 테이블과 매핑

public class Posts {
    @Id                                              // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
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

    // 도메인 메서드 (Setter 대신)
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}