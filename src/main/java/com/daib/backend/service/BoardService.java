package com.daib.backend.service;

import com.daib.backend.domain.board.Comment;
import com.daib.backend.domain.board.Post;
import com.daib.backend.dto.CommentDTO;
import com.daib.backend.dto.PostDTO;
import com.daib.backend.repository.BoardRepository;
import com.daib.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    private CommentRepository commentRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    public long savePost(PostDTO postDTO) {
        return boardRepository.save(postDTO.toEntity()).getId();
    }

    public PostDTO getPost(Long id) {
        Post post = boardRepository.getById(id);
        return toPostDTO(post);
    }

    @Transactional
    public long updatePost(Long id, PostDTO postDTO) {
        return boardRepository.updatePost(postDTO.getTitle(), postDTO.getContent(), id);
    }

    @Transactional
    public long deletePost(Long id) {
        return boardRepository.deletePost(id);
    }

    static PostDTO toPostDTO(Post post) {
        PostDTO postDTO = PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .writer(post.getWriter())
                .build();

        return postDTO;
    }

    public Comment saveComment(Long id, CommentDTO commentDTO) {
        Post post = boardRepository.getById(id);

        Comment comment = commentDTO.toEntity();
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    @Transactional
    public long updateComment(CommentDTO commentDTO, Long commentId) {
        return commentRepository.updateComment(commentDTO.getContent(), commentId);
    }

    @Transactional
    public long deleteComment(Long commentId) {
        return commentRepository.deleteComment(commentId);
    }
}
