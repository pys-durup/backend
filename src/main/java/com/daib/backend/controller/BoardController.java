package com.daib.backend.controller;

import com.daib.backend.domain.board.Comment;
import com.daib.backend.dto.CommentDTO;
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
    public Long createPost(@RequestBody PostDTO postDTO) {

        long result = boardService.savePost(postDTO);
        log.debug("글쓰기 성공 - 글 번호 = {}", result);
        return result;
    }

    @GetMapping("/{id}")
    public PostDTO readPost(@PathVariable("id") Long id) {
        PostDTO post = boardService.getPost(id);
        log.debug("글 정보 가져오기 성공 - 글 번호 = {}", post.getId());
        return post;
    }

    @PatchMapping("/{id}")
    public Long updatePost(@PathVariable("id") Long id,
                           @RequestBody PostDTO postDTO) {
        // 수정할 글번호, 수정할 글정보
        log.debug("수정 글 번호 = {}, 제목 = {}, 내용 = {}",
                id, postDTO.getTitle(), postDTO.getContent());
        long result = boardService.updatePost(id, postDTO);
        log.debug("글 수정 성공 - 글 번호 = {} ", id);
        return result;
    }

    @DeleteMapping("/{id}")
    public Long deletePost(@PathVariable("id") Long id) {

        // 게시글 삭제시 게시글의 내용(content)만 삭제되도록 하고, 댓글은 삭제되지 않도록 처리
        long result = boardService.deletePost(id);
        log.debug("글 삭제 성공 - 글 번호 = {} ", id);
        return result;
    }

    // 댓글 쓰기
    @PostMapping("/{id}/comment")
    public Long createComment(@PathVariable("id") Long id,
                              @RequestBody CommentDTO commentDTO) {

        Comment comment = boardService.saveComment(id, commentDTO);
        log.debug("댓글 생성 성공: 글번호 = {}, 댓글번호 = {}" , id, comment.getId());

        return comment.getId();
    }

    // 댓글 수정
    @PatchMapping("/{id}/comment/{commentId}")
    public Long updateComment(@PathVariable("id") Long id,
                              @RequestBody CommentDTO commentDTO,
                              @PathVariable("commentId") Long commentId) {

        long result = boardService.updateComment(commentDTO, commentId);
        log.debug("댓글 수정 성공: 글번호 = {}, 댓글번호 = {}" , id, commentId);
        return result;
    }

    // 댓글 삭제
    @DeleteMapping("/{id}/comment/{commentId}")
    public Long deleteComment(@PathVariable("id") Long id,
                              @PathVariable("commentId") Long commentId) {

        long result = boardService.deleteComment(commentId);
        log.debug("댓글 삭제 성공: 글번호 = {}, 댓글번호 = {}" , id, commentId);
        return result;
    }

}
