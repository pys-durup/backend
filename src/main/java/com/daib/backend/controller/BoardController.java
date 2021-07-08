package com.daib.backend.controller;

import com.daib.backend.domain.board.Post;
import com.daib.backend.dto.PostDTO;
import com.daib.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Long create(@RequestBody PostDTO postDTO) {

        return boardService.savePost(postDTO);
    }

    @GetMapping("/{id}")
    public PostDTO read(@PathVariable("id") Long id) {
        System.out.println(id);
        return boardService.getPost(id);
    }
}
