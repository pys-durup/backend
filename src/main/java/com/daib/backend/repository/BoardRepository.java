package com.daib.backend.repository;

import com.daib.backend.domain.board.Comment;
import com.daib.backend.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Post, Long> {

    @Modifying
    @Query("UPDATE Post p SET p.title = :title, p.content = :content WHERE p.id = :id")
    int updatePost(String title, String content, Long id);
}
