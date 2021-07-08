package com.daib.backend.repository;

import com.daib.backend.domain.board.Comment;
import com.daib.backend.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Post, Long> {
}
