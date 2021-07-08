package com.daib.backend.dto;

import com.daib.backend.domain.board.Comment;
import com.daib.backend.domain.board.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public PostDTO(Long id, String title, String content, String writer, LocalDateTime createdAt, List<Comment> commentList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.commentList = commentList;
    }

    public Post toEntity() {
        Post post = Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .createdAt(createdAt)
                .commentList(commentList)
                .build();
        return post;
    }
}
