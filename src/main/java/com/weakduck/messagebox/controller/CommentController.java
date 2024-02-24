package com.weakduck.messagebox.controller;

import com.weakduck.messagebox.dto.CreateCommentDTO;
import com.weakduck.messagebox.dto.DeleteCommentDTO;
import com.weakduck.messagebox.model.Comment;
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
    public ResponseEntity<ApiResponse<MyPage<Comment>>> getAllComments(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        MyPage<Comment> pageResult = commentService.findAllComments(page,size);
        return ResponseEntity.ok(ApiResponse.success(pageResult));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<String>> createComment(@RequestBody CreateCommentDTO createCommentDTO) {
        commentService.saveComment(createCommentDTO);
        return ResponseEntity.ok(ApiResponse.success(""));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id, @RequestBody DeleteCommentDTO body) throws FailedLoginException {

        if (commentService.findCommentById(id).isPresent()) {
            commentService.deleteComment(id, body.getAdminPassword());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
