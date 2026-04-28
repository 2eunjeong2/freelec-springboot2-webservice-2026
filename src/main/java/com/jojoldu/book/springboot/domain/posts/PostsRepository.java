package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findByAuthor(String author);          // (1) 메서드명 규칙
}

