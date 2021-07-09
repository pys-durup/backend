package com.daib.backend.repository;

import com.daib.backend.domain.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Modifying
    @Query("UPDATE Comment c SET c.content = :content WHERE c.id = :id")
    int updateComment(String content, Long id);

    @Modifying
    @Query("UPDATE Comment c SET c.content = '삭제된 댓글 입니다' WHERE c.id = :id")
    int deleteComment(Long id);

    List<Comment> findAllByPostId(Long id);
}
