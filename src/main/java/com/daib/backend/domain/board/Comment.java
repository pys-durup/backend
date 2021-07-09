package com.daib.backend.domain.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String writer;

    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Comment(Long id, Post post, String writer, String content, LocalDateTime createdAt) {
        this.id = id;
        this.post = post;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }
}
