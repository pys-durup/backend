package com.daib.backend.controller;

import com.daib.backend.domain.board.Post;
import com.daib.backend.dto.PostDTO;
import com.daib.backend.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Long create(@RequestBody PostDTO postDTO) {

        long result = boardService.savePost(postDTO);
        log.debug("글쓰기 성공 - 글 번호 = {}", result);
        return result;
    }

    @GetMapping("/{id}")
    public PostDTO read(@PathVariable("id") Long id) {
        PostDTO post = boardService.getPost(id);
        log.debug("글 정보 가져오기 성공 - 글 번호 = {}", post.getId());
        return post;
    }

    @PatchMapping("/{id}")
    public Long update(@PathVariable("id") Long id,
                       @RequestBody PostDTO postDTO) {
        // 수정할 글번호, 수정할 글정보
        log.debug("수정 글 번호 = {}, 제목 = {}, 내용 = {}",
                        id, postDTO.getTitle(), postDTO.getContent());
        long result = boardService.updatePost(id, postDTO);
        log.info("글 수정 성공 - 글 번호 = {} ", id);
        return result;
    }
}
