package com.daib.backend.dto;

import com.daib.backend.domain.board.Comment;
import com.daib.backend.domain.board.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private Post post;
    private String writer;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    public CommentDTO(Long id, Post post, String writer, String content, LocalDateTime createdAt) {
        this.id = id;
        this.post = post;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment toEntity() {
        Comment comment = Comment.builder()
                .id(id)
                .post(post)
                .writer(writer)
                .content(content)
                .createdAt(createdAt)
                .build();

        return comment;
    }
}
