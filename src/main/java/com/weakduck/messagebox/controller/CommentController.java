package com.weakduck.messagebox.controller;

import com.weakduck.messagebox.dto.CommentDTO;
import com.weakduck.messagebox.dto.CreateCommentDTO;
import com.weakduck.messagebox.dto.DeleteCommentDTO;
import com.weakduck.messagebox.response.ApiResponse;
import com.weakduck.messagebox.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.weakduck.messagebox.dto.MyPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<MyPage<CommentDTO>>> getAllComments(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        MyPage<CommentDTO> pageResult = commentService.findAllComments(page,size);
        return ResponseEntity.ok(ApiResponse.success(pageResult));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<CommentDTO>> createComment(@RequestBody CreateCommentDTO createCommentDTO) {
        return ResponseEntity.ok(ApiResponse.success(commentService.saveComment(createCommentDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id, @RequestBody DeleteCommentDTO body) throws FailedLoginException {

        if (commentService.findCommentById(id).isPresent()) {
            commentService.deleteComment(id, body.getPassword());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
