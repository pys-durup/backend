package com.daib.backend.service;

import com.daib.backend.domain.board.Post;
import com.daib.backend.dto.PostDTO;
import com.daib.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
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
}
