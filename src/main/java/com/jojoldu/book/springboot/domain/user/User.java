package com.jojoldu.book.springboot.domain.user;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@NoArgsConstructor
@Entity

@Table(name = "users") // 테이블 명을 users 로 변경 (USER 는 H2/MariaDB 예약어)

public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column
    private String picture;
    @Enumerated(EnumType.STRING)   // ⭐ DB 에 enum 이름 자체를 저장 (GUEST / USER)
    @Column(nullable = false)

    private Role role;
    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name    = name;
        this.email   = email;
        this.picture = picture;
        this.role    = role;
    }

    public User update(String name, String picture) {
        this.name    = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
