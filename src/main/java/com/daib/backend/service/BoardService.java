package com.daib.backend.service;

import com.daib.backend.domain.board.Post;
import com.daib.backend.dto.PostDTO;
import com.daib.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
