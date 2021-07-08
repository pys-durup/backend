package com.daib.backend.controller;

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
}
